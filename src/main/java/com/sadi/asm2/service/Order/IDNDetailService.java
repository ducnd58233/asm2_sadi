package com.sadi.asm2.service.Order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.IDNDetail;


@Service
@Transactional
public class IDNDetailService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public IDNDetail createIDNDetail(IDNDetail idnDetail) {
		this.sessionFactory.getCurrentSession().save(idnDetail);
		return idnDetail;
	}
	
	public List<IDNDetail> getAllIDNDetails(){
		return this.sessionFactory.getCurrentSession().createQuery("from IDNDetail").list();
	}
	
	public IDNDetail getIDNDetail(int id) {
		return this.sessionFactory.getCurrentSession().get(IDNDetail.class, id);
	}
	
	public void updateIDNDetail(IDNDetail idn) {
		this.sessionFactory.getCurrentSession().update(idn);
	}
	
	public void deleteIDNDetail(int id) {
		IDNDetail idn = this.getIDNDetail(id);
		this.sessionFactory.getCurrentSession().delete(idn);
	}
	
	
	public List<IDNDetail> searchIDNDetail(IDNDetail idnDetail){
		List<IDNDetail> idnDetailList = this.sessionFactory.getCurrentSession()
				.createQuery("from IDNDetail where id= :id or idn= :idn or quantity= :quantity")
				.setParameter("id", idnDetail.getId())
				.setParameter("idn", idnDetail.getInventory_delivery_note())
				.setParameter("quantity", idnDetail.getQuantity())
				.list();
		return idnDetailList;
	}
	
	public List<IDNDetail> getAllPaginatedOrderDetail(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(IDNDetail.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords);
        
        return (List) criteria.list();
		 
	}
}
