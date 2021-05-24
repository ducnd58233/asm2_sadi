package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.IRNDetail;
import com.sadi.asm2.service.Order.IRNDetailService;


@RestController
@RequestMapping(path="irndetails")
public class IRNDetailController {
	@Autowired
	private IRNDetailService irnDetailService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public IRNDetail createIRNDetail(@RequestBody IRNDetail irnDetail) {
		return this.irnDetailService.createIRNDetail(irnDetail);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<IRNDetail> getAllIRNDetails(){
		return this.irnDetailService.getAllIRNDetails();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public IRNDetail getIRNDetail(@PathVariable int id) {
		return this.irnDetailService.getIRNDetail(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateIRNDetail(@PathVariable int id, @RequestBody IRNDetail newIRNDetail) {
		IRNDetail currentIRNDetail = this.irnDetailService.getIRNDetail(id);
		currentIRNDetail.setInventory_receiving_note(newIRNDetail.getInventory_receiving_note());
		currentIRNDetail.setQuantity(newIRNDetail.getQuantity());
		this.irnDetailService.updateIRNDetail(currentIRNDetail);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteIRNDetail(@PathVariable int id) {
		this.irnDetailService.deleteIRNDetail(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<IRNDetail> searchOrder(@RequestBody IRNDetail irnDetail){
		return this.irnDetailService.searchIRNDetail(irnDetail);
	}
}
