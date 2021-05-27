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
		return this.sessionFactory.getCurrentSession().createQuery("from Orders").list();
	}
	
	public Orders getOrder(int id) {
		return this.sessionFactory.getCurrentSession().get(Orders.class, id);
	}
	
	public void updateOrder(Orders orders) {
		if(orders.getOrderDetail()!=null) {
			for(OrderDetail orderDetail: orders.getOrderDetail()) {
				orderDetail.setOrders(orders);
			}
		}
		this.sessionFactory.getCurrentSession().update(orders);
	}
	
	public void deleteOrder(int id) {
		Orders orders = this.getOrder(id);
		this.sessionFactory.getCurrentSession().delete(orders);
	}
	
	
	public List<Orders> searchOrder(Orders orders){
		List<Orders> orderList = this.sessionFactory.getCurrentSession()
				.createQuery("from Order where id= :id or staff= :staff or staffId= :staffId or provider= :provider or providerId= :providerId or date= :date")
				.setParameter("id", orders.getId())
				.setString("staff", orders.getStaff().getName())
				.setInteger("staffId", orders.getStaff().getId())
				.setString("provider", orders.getProvider().getName())
				.setInteger("providerId", orders.getProvider().getId())
				.setDate("date", orders.getDate())
				.list();
		return orderList;
	}
	
	public List<Orders> getAllPaginatedOrders(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(Orders.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords);
        
        return (List) criteria.list();
		  
	}
}
