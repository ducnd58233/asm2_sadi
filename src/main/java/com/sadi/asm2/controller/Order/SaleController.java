package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.model.Order.SaleInvoice;
import com.sadi.asm2.service.Order.SaleService;

@RestController
@RequestMapping(path="sales")
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public SaleInvoice createSaleInvoice(@RequestBody SaleInvoice saleInvoice) {
		return this.saleService.createSaleInvoice(saleInvoice);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<SaleInvoice> getAllSaleInvoices(){
		return this.saleService.getAllSaleInvoice();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public SaleInvoice getSaleInvoice(@PathVariable int id) {
		return this.saleService.getSaleInvoice(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateSaleInvoice(@PathVariable int id, @RequestBody SaleInvoice newSaleInvoice) {
		SaleInvoice currentSaleInvoice = this.saleService.getSaleInvoice(id);
		currentSaleInvoice.setDate(newSaleInvoice.getDate());
		currentSaleInvoice.setCustomer(newSaleInvoice.getCustomer());
		currentSaleInvoice.setStaff(newSaleInvoice.getStaff());
		currentSaleInvoice.setTotal(newSaleInvoice.getTotal());
		this.saleService.updateSaleInvoice(currentSaleInvoice);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteSaleInvoice(@PathVariable int id) {
		this.saleService.deleteSaleInvoice(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<SaleInvoice> searchSaleInvoice(@RequestBody SaleInvoice saleInvoice){
		return this.saleService.searchSaleInvoice(saleInvoice);
	}
	
	@RequestMapping(path= "/page", method=RequestMethod.GET)
	public List<SaleInvoice> getAllPaginatedSaleInvoices(@RequestParam int startRecord, @RequestParam int maxRecords){
		return this.saleService.getAllPaginatedSaleInvoices(startRecord, maxRecords);
	}
}
