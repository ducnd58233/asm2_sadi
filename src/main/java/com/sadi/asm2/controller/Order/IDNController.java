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

import com.sadi.asm2.model.Order.InventoryDeliveryNote;
import com.sadi.asm2.model.Order.InventoryReceivingNote;
import com.sadi.asm2.service.Order.IDNService;

@RestController
@RequestMapping(path="idns")
public class IDNController {
	@Autowired
	private IDNService idnService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public InventoryDeliveryNote createIDN(@RequestBody InventoryDeliveryNote idn) {
		return this.idnService.createIDN(idn);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<InventoryDeliveryNote> getAllIDNs(){
		return this.idnService.getAllIDNs();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public InventoryDeliveryNote getIDN(@PathVariable int id) {
		return this.idnService.getIDN(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateIDN(@PathVariable int id, @RequestBody InventoryDeliveryNote newIDN) {
		InventoryDeliveryNote currentIDN = this.idnService.getIDN(id);
		currentIDN.setDate(newIDN.getDate());
		currentIDN.setProductId(newIDN.getProductId());
		currentIDN.setStaffId(newIDN.getStaffId());
		currentIDN.setQuantity(newIDN.getQuantity());
//		currentIRN.setProvider(newIRN.getProvider());
//		currentIRN.setStaff(newIRN.getStaff());
		this.idnService.updateIDN(currentIDN);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteIDN(@PathVariable int id) {
		this.idnService.deleteIDN(id);
	}
	
	@RequestMapping(path="/seach", method=RequestMethod.POST)
	public List<InventoryDeliveryNote> searchIDN(@RequestBody InventoryDeliveryNote idn){
		return this.idnService.searchIDN(idn);
	}
	
	@RequestMapping(path = "/page" , method = RequestMethod.GET )
	public List<InventoryDeliveryNote> getAllPaginatedIdns(@RequestParam Date startDate, @RequestParam Date endDate) { 
		return this.idnService.getAllIDNsByDates(startDate, endDate);
	}
}
