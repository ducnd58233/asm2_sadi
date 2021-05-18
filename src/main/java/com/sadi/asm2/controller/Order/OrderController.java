package com.sadi.asm2.controller.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.service.Order.OrderService;

@RestController
@RequestMapping(path="orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public Orders createOrder(@RequestBody Orders orders) {
		return this.orderService.createOrder(orders);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Orders> getAllOrders(){
		return this.orderService.getAllOrders();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Orders getOrder(@PathVariable int id) {
		return this.orderService.getOrder(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateOrder(@PathVariable int id, @RequestBody Orders newOrder) {
		Orders currentOrder = this.orderService.getOrder(id);
		currentOrder.setDate(newOrder.getDate());
		currentOrder.setProvider(newOrder.getProvider());
		currentOrder.setStaff(newOrder.getStaff());
		this.orderService.updateOrder(currentOrder);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteOrder(@PathVariable int id) {
		this.orderService.deleteOrder(id);
	}
	
	@RequestMapping(path="/seach", method=RequestMethod.POST)
	public List<Orders> searchOrder(@RequestBody Orders orders){
		return this.orderService.searchOrder(orders);
	}
}
