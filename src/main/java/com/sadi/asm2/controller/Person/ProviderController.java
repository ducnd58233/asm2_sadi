package com.sadi.asm2.controller.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Person.Provider;
import com.sadi.asm2.service.Person.ProviderService;

@RestController
@RequestMapping(path="providers")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public Provider createProvider(@RequestBody Provider provider) {
		return this.providerService.addProvider(provider);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Provider> getAllProviders(){
		return this.providerService.getAllProviders();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Provider getCustomer(@PathVariable int id) {
		return this.providerService.getProvider(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateCustomer(@PathVariable int id, @RequestBody Provider newProvider) {
		Provider currentProvider = providerService.getProvider(id);
		currentProvider.setAddress(newProvider.getAddress());
		currentProvider.setEmail(newProvider.getEmail());
		currentProvider.setName(newProvider.getName());
		currentProvider.setPhone(newProvider.getPhone());
		currentProvider.setFax(newProvider.getFax());
		currentProvider.setContact_person(newProvider.getContact_person());
		this.providerService.updateProvider(currentProvider);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteProvider(@PathVariable int id) {
		this.providerService.deleteProvider(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<Provider> searchCustomer(@RequestBody Provider provider) {
		return this.providerService.searchProvider(provider);
	}
}
