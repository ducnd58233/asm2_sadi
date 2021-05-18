package com.sadi.asm2.controller.Order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.InventoryReceivingNote;
import com.sadi.asm2.service.Order.IRNService;

@RestController
@RequestMapping(path="irns")
public class IRNController {
	@Autowired
	private IRNService irnService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public InventoryReceivingNote createIRN(@RequestBody InventoryReceivingNote irn) {
		return this.irnService.createIRN(irn);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<InventoryReceivingNote> getAllIRNs(){
		return this.irnService.getAllIRNs();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public InventoryReceivingNote getIRN(@PathVariable int id) {
		return this.irnService.getIRN(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateIRN(@PathVariable int id, @RequestBody InventoryReceivingNote newIRN) {
		InventoryReceivingNote currentIRN = this.irnService.getIRN(id);
		currentIRN.setDate(newIRN.getDate());
		currentIRN.setProductId(newIRN.getProductId());
		currentIRN.setStaffId(newIRN.getStaffId());
		currentIRN.setQuantity(newIRN.getQuantity());
//		currentIRN.setProvider(newIRN.getProvider());
//		currentIRN.setStaff(newIRN.getStaff());
		this.irnService.updateIRN(currentIRN);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteIRN(@PathVariable int id) {
		this.irnService.deleteIRN(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<InventoryReceivingNote> searchIRN(@RequestBody InventoryReceivingNote irn){
		return this.irnService.searchIRN(irn);
	}
	
	@RequestMapping(path = "/page" , method = RequestMethod.GET )
	public List<InventoryReceivingNote> getAllPaginatedIrns(@RequestParam Date startDate, @RequestParam Date endDate) { 
		return this.irnService.getAllIRNsByDates(startDate, endDate);
	}
}
