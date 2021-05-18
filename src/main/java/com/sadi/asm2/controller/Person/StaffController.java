package com.sadi.asm2.controller.Person;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Person.Staff;
import com.sadi.asm2.service.Person.StaffService;

@RestController
@RequestMapping(path = "/staffs")
public class StaffController {
	@Autowired 
	private StaffService staffService;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Staff createStaff(@RequestBody Staff staff) {
		return this.staffService.createStaff(staff);
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
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
		this.staffService.updateStaff(newStaff);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteStaff(@PathVariable int id) {
		this.staffService.deleteStaff(id);
	}
	
	@RequestMapping(path = "/search" , method = RequestMethod.POST)
	public List<Staff> searchStaff(@RequestBody Staff staff) {
		return this.staffService.searchStaff(staff);
	}
//	
//	@RequestMapping(path= "/page", method=RequestMethod.GET)
//	public List<Staff> getAllPaginatedStaffs(@RequestParam int startRecord, @RequestParam int maxRecords){
//		return this.staffService.getAllPaginatedStaffs(startRecord, maxRecords);
//	}
}
