package com.sadi.asm2.controller;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Person.Staff;
import com.sadi.asm2.service.StaffService;

@RestController
@RequestMapping(path = "/staffs")
public class StaffController {
	@Autowired 
	private StaffService staffService;
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Staff createStaff(@RequestBody Staff staff) {
		return this.staffService.createStaff(staff);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Staff> getAllStaffs() {
		return this.staffService.getAllStaffs();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Staff getStaff(@PathVariable int id) {
		return this.staffService.getStaff(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateStaff(@PathVariable int id, @RequestBody Staff newStaff) {
		Staff currentStaff = this.staffService.getStaff(id);
		currentStaff.setAddress(newStaff.getAddress());
		currentStaff.setEmail(newStaff.getEmail());
		currentStaff.setName(newStaff.getName());
		currentStaff.setPhone(newStaff.getPhone());
		this.staffService.updateStaff(currentStaff);
	}
	
	@RequestMapping(path = { "staffs/search" }, method = { RequestMethod.POST })
	public List<Staff> searchStaff(@RequestBody Staff staff) {
		return this.staffService.searchStaff(staff);

	}
	
}
