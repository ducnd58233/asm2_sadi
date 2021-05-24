package com.sadi.asm2.service.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.IRNDetail;


@Service
@Transactional
public class IRNDetailService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public IRNDetail createIRNDetail(IRNDetail irnDetail) {
		this.sessionFactory.getCurrentSession().save(irnDetail);
		return irnDetail;
	}
	
	public List<IRNDetail> getAllIRNDetails(){
		return this.sessionFactory.getCurrentSession().createQuery("from IRNDetail").list();
	}
	
	public IRNDetail getIRNDetail(int id) {
		return this.sessionFactory.getCurrentSession().get(IRNDetail.class, id);
	}
	
	public void updateIRNDetail(IRNDetail irn) {
		this.sessionFactory.getCurrentSession().update(irn);
	}
	
	public void deleteIRNDetail(int id) {
		IRNDetail irn = this.getIRNDetail(id);
		this.sessionFactory.getCurrentSession().delete(irn);
	}
	
	
	public List<IRNDetail> searchIRNDetail(IRNDetail irnDetail){
		List<IRNDetail> irnDetailList = this.sessionFactory.getCurrentSession()
				.createQuery("from IRNDetail where id= :id or irn= :irn or quantity= :quantity")
				.setParameter("id", irnDetail.getId())
				.setParameter("irn", irnDetail.getInventory_receiving_note())
				.setParameter("quantity", irnDetail.getQuantity())
				.list();
		return irnDetailList;
	}
	
	public List<IRNDetail> getAllPaginatedOrderDetail(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(IRNDetail.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords);
        
        return (List) criteria.list();
		 
	}
}
