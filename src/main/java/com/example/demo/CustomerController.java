package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;
	
	
	@RequestMapping("/save")
	public String process(@RequestParam("id") String id,@RequestParam("id1") String id1){
		repository.save(new Customer(id, id1));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/update")
	public void updateTopic(@RequestParam("id1") long id1,@RequestParam("id2") String id2,@RequestParam("id3") String id3)
	{
		Customer result;
		result = repository.findOne(id1);
		result.setId(id1);
		result.setFname(id2);
		result.setLname(id3);

	}
	@RequestMapping("/delete")
	public void deleteTopic(@RequestParam("id") long id)
	{
		Customer cust;
		cust = repository.findOne(id);
		repository.delete(cust);

	}
	


	
}