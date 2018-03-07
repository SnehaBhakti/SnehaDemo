package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
 
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
 
	@Column(name = "firstname")
	private String firstName;
 
	@Column(name = "lastname")
	private String lastName;
 
	protected Customer() {
	}
 
	public void setId(long id)
	{ 
		this.id=id;
	}
	public void setFname(String fname)
	{ 
		this.firstName=fname;
	}
	public void setLname(String lname)
	{ 
		this.lastName=lname;
	}
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Customer(int id,String firstName, String lastName) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
