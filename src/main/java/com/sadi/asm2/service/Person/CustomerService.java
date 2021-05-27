package com.sadi.asm2.service.Person;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Person.Customer;
import com.sadi.asm2.model.Person.Staff;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Customer addCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		return this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	public Customer getCustomer(int id) {
		return (Customer) this.sessionFactory.getCurrentSession().get(Customer.class, id);
	}
	
	public void updateCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().update(customer);
	}
	
	public void deleteCustomer(int id) {
		Customer customer = this.getCustomer(id);
		this.sessionFactory.getCurrentSession().delete(customer);
	}
	
	public List<Customer> searchCustomer(Customer customer){
		List<Customer> customerList = this.sessionFactory.getCurrentSession()
				.createQuery("from Customer where id= :id or name= :name or address= :address or phone= :phone or fax= :fax or email= :email")
				.setInteger("id", customer.getId())
				.setString("name", customer.getName())
				.setString("address", customer.getAddress())
				.setString("phone", customer.getPhone())
				.list();
		return customerList;
	}

	public List<Customer> getAllPaginatedCustomers(int startRecord, int maxRecords) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(startRecord);
		criteria.setMaxResults(maxRecords);
		return (List) criteria.list();
	}
}
