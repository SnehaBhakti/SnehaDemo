package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
