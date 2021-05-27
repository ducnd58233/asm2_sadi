package com.sadi.asm2.controller.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Person.Customer;
import com.sadi.asm2.service.Person.CustomerService;

@RestController
@RequestMapping(path="customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable int id) {
		return this.customerService.getCustomer(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateCustomer(@PathVariable int id, @RequestBody Customer newCustomer) {
		Customer currentCustomer = customerService.getCustomer(id);
		currentCustomer.setAddress(newCustomer.getAddress());
		currentCustomer.setEmail(newCustomer.getEmail());
		currentCustomer.setName(newCustomer.getName());
		currentCustomer.setPhone(newCustomer.getPhone());
		currentCustomer.setFax(newCustomer.getFax());
		currentCustomer.setContact_person(newCustomer.getContact_person());
		this.customerService.updateCustomer(currentCustomer);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable int id) {
		this.customerService.deleteCustomer(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<Customer> searchCustomer(@RequestBody Customer customer) {
		return this.customerService.searchCustomer(customer);
	}
	
	@RequestMapping(path= "/page", method=RequestMethod.GET)
	public List<Customer> getAllPaginatedCustomers(@RequestParam int startRecord, @RequestParam int maxRecords){
		return this.customerService.getAllPaginatedCustomers(startRecord, maxRecords);
	}
}
