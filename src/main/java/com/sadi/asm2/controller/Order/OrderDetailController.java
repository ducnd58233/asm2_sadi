package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.OrderDetail;
import com.sadi.asm2.service.Order.OrderDetailService;

@RestController
@RequestMapping(path="orderdetails")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
		return this.orderDetailService.createOrderDetail(orderDetail);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<OrderDetail> getAllOrderDetails(){
		return this.orderDetailService.getAllOrderDetails();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public OrderDetail getOrderDetail(@PathVariable int id) {
		return this.orderDetailService.getOrderDetail(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateOrderDetail(@PathVariable int id, @RequestBody OrderDetail newOrderDetail) {
		OrderDetail currentOrderDetail = this.orderDetailService.getOrderDetail(id);
		currentOrderDetail.setProduct(newOrderDetail.getProduct());
		currentOrderDetail.setQuantity(newOrderDetail.getQuantity());
		currentOrderDetail.setPrice(newOrderDetail.getPrice());
		this.orderDetailService.updateOrderDetail(currentOrderDetail);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteOrderDetail(@PathVariable int id) {
		this.orderDetailService.deleteOrderDetail(id);
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public List<OrderDetail> searchOrder(@RequestBody OrderDetail orderDetail){
		return this.orderDetailService.searchOrderDetail(orderDetail);
	}
}
