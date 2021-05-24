package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.IDNDetail;
import com.sadi.asm2.service.Order.IDNDetailService;

@RestController
@RequestMapping(path="idndetails")
public class IDNDetailController {
	@Autowired
	private IDNDetailService idnDetailService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public IDNDetail createIDNDetail(@RequestBody IDNDetail idnDetail) {
		return this.idnDetailService.createIDNDetail(idnDetail);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<IDNDetail> getAllIDNDetails(){
		return this.idnDetailService.getAllIDNDetails();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public IDNDetail getIDNDetail(@PathVariable int id) {
		return this.idnDetailService.getIDNDetail(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateIDNDetail(@PathVariable int id, @RequestBody IDNDetail newIDNDetail) {
		IDNDetail currentIDNDetail = this.idnDetailService.getIDNDetail(id);
		currentIDNDetail.setInventory_delivery_note(newIDNDetail.getInventory_delivery_note());
		currentIDNDetail.setQuantity(newIDNDetail.getQuantity());
		this.idnDetailService.updateIDNDetail(currentIDNDetail);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteIDNDetail(@PathVariable int id) {
		this.idnDetailService.deleteIDNDetail(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<IDNDetail> searchOrder(@RequestBody IDNDetail idnDetail){
		return this.idnDetailService.searchIDNDetail(idnDetail);
	}
}
