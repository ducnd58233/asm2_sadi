package com.sadi.asm2.service.Order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.OrderDetail;
import com.sadi.asm2.model.Order.Orders;

@Service
@Transactional
public class OrderDetailService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		this.sessionFactory.getCurrentSession().save(orderDetail);
		return orderDetail;
	}
	
	public List<OrderDetail> getAllOrderDetails() {
		return this.sessionFactory.getCurrentSession().createQuery("from OrderDetail").list();
	}
	
	public OrderDetail getOrderDetail(int id) {
		return this.sessionFactory.getCurrentSession().get(OrderDetail.class, id);
	}
	
	public void updateOrderDetail(OrderDetail orderDetail) {
		this.sessionFactory.getCurrentSession().update(orderDetail);
	}
	
	public void deleteOrderDetail(int id) {
		OrderDetail orderDetail = this.getOrderDetail(id);
		this.sessionFactory.getCurrentSession().delete(orderDetail);
	}
	
	public List<OrderDetail> searchOrderDetail(OrderDetail orderDetail){
		List<OrderDetail> orderDetailList = this.sessionFactory.getCurrentSession()
				.createQuery("from OrderDetail where id= :id or product= :product or productId= :productId or price= :price")
				.setInteger("id", orderDetail.getId())
				.setString("product", orderDetail.getProduct().getName())
				.setInteger("productId", orderDetail.getProduct().getId())
				.setInteger("price", orderDetail.getPrice())
				.list();
		return orderDetailList;
	}
	
	public List<OrderDetail> getAllPaginatedOrderDetail(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(OrderDetail.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords);
        
        return (List) criteria.list();
		  
	}
}
