package com.sadi.asm2.service.Production;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Production.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	public Category createCategory(Category category) {
		this.sessionFactory.getCurrentSession().save(category);
		return category;
	}
	
	public List<Category> getAllCategories() {
		return this.sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	
	public Category getCategory(int id) {
		return (Category) this.sessionFactory.getCurrentSession().get(Category.class, id);
	}
	
	public void updateCategory(Category category) {
		this.sessionFactory.getCurrentSession().update(category);
	}
	
	public void deleteCategory(int id) {
		Category category = this.getCategory(id);
		this.sessionFactory.getCurrentSession().delete(category);
	}
	public List<Category> searchCategory(Category category) {

		List<Category> categoryList = this.sessionFactory.getCurrentSession()
				.createQuery("from Category where id=:id or name like :name")
				.setInteger("id", category.getId())
				.setString("name", "%" + category.getName() + "%").list();
		return categoryList;
	}
	
	public List<Category> getAllPaginatedCategories(int startRecord, int maxRecords) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.setFirstResult(startRecord);
		criteria.setMaxResults(maxRecords);

		List categoryList = (List) criteria.list();
		return categoryList;
	}
}
