package com.sadi.asm2.service.Order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.model.Person.Customer;



@Service
@Transactional
public class OrderService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public Orders createOrder(Orders orders) {
		this.sessionFactory.getCurrentSession().save(orders);
		return orders;
	}
	
	public List<Orders> getAllOrders() {
		return this.sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	
	public Orders getOrder(int id) {
		return (Orders) this.sessionFactory.getCurrentSession().get(Orders.class, id);
	}
	
	public void updateOrder(Orders orders) {
		this.sessionFactory.getCurrentSession().update(orders);
	}
	
	public void deleteOrder(int id) {
		Orders orders = this.getOrder(id);
		this.sessionFactory.getCurrentSession().delete(orders);
	}
	
	
	public List<Orders> searchOrder(Orders orders){
		List<Orders> orderList = this.sessionFactory.getCurrentSession()
				.createQuery("from Order where id= :id or staff= :staff or provider= :provider or date= :date")
				.setParameter("id", orders.getId())
				.setParameter("staff", orders.getStaff().getName())
				.setParameter("provider", orders.getProvider().getName())
				.setParameter("date", orders.getDate())
				.list();
		return orderList;
	}
}
