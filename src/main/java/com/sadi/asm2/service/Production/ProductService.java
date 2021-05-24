package com.sadi.asm2.service.Production;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Production.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Product createProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		return product;
	}
	
	public List<Product> getAllProducts(){
		return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	public Product getProduct(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	public void updateProduct(Product product) {
		this.sessionFactory.getCurrentSession().update(product);
	}
	
	public void deleteProduct(int id) {
		Product product = this.getProduct(id);
		this.sessionFactory.getCurrentSession().delete(product);
	}
	
	public List<Product> searchProduct(Product product) {
		List<Product> productList = this.sessionFactory.getCurrentSession()
				.createQuery("from Product where id= :id  or company= :company or name= :name or model= :model or brand= :brand or price= :price or description= :description or category= :category ") 
				 .setParameter("id", product.getId())
				 .setParameter("name", product.getName())
				 .setParameter("model", product.getModel())
				 .setParameter("brand", product.getBrand())
				 .setParameter("company", product.getCompany())
				 .setParameter("description", product.getDescription())
				 .setParameter("category", product.getCategory())
				 .setParameter("price", product.getPrice())
				.list();
		
		return productList;
	}
	
	public List<Product> getAllPaginatedProduct(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(Product.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords);        
		return (List) criteria.list();
	}
}
