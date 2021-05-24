package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.SaleInvoiceDetail;
import com.sadi.asm2.service.Order.SaleDetailService;

@RestController
@RequestMapping(path="saledetails")
public class SaleDetailController {
	@Autowired
	private SaleDetailService saleDetailService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public SaleInvoiceDetail createSaleInvoiceDetail(@RequestBody SaleInvoiceDetail saleInvoice) {
		return this.saleDetailService.createSaleInvoiceDetail(saleInvoice);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<SaleInvoiceDetail> getAllSaleInvoiceDetails(){
		return this.saleDetailService.getAllSaleInvoiceDetails();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public SaleInvoiceDetail getSaleInvoiceDetail(@PathVariable int id) {
		return this.saleDetailService.getSaleInvoiceDetail(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateSaleInvoiceDetail(@PathVariable int id, @RequestBody SaleInvoiceDetail newSaleInvoiceDetail) {
		SaleInvoiceDetail currentInvoiceDetail= this.saleDetailService.getSaleInvoiceDetail(id);
		currentInvoiceDetail.setProduct(newSaleInvoiceDetail.getProduct());
		currentInvoiceDetail.setQuantity(newSaleInvoiceDetail.getQuantity());
		currentInvoiceDetail.setPrice(newSaleInvoiceDetail.getPrice());
		currentInvoiceDetail.setSaleInvoice(newSaleInvoiceDetail.getSaleInvoice());
		this.saleDetailService.updateSaleInvoiceDetail(currentInvoiceDetail);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteSaleInvoiceDetail(@PathVariable int id) {
		this.saleDetailService.deleteSaleInvoiceDetail(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<SaleInvoiceDetail> searchSaleInvoiceDetail(@RequestBody SaleInvoiceDetail saleInvoice){
		return this.saleDetailService.searchSaleInvoiceDetail(saleInvoice);
	}
	
	@RequestMapping(path= "/page", method=RequestMethod.GET)
	public List<SaleInvoiceDetail> getAllPaginatedSaleInvoiceDetails(@RequestParam int startRecord, @RequestParam int maxRecords){
		return this.saleDetailService.getAllPaginatedSaleInvoiceDetails(startRecord, maxRecords);
	}
}
