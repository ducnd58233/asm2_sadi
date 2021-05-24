package com.sadi.asm2.service.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.IRNDetail;
import com.sadi.asm2.model.Order.InventoryReceivingNote;
import com.sadi.asm2.model.Order.Orders;

@Service
@Transactional
public class IRNService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public InventoryReceivingNote createIRN(InventoryReceivingNote irn) {
		this.sessionFactory.getCurrentSession().save(irn);
		return irn;
	}
	
	public List<InventoryReceivingNote> getAllIRNs(){
		return this.sessionFactory.getCurrentSession().createQuery("from InventoryReceivingNote").list();
	}
	
	public InventoryReceivingNote getIRN(int id) {
		return this.sessionFactory.getCurrentSession().get(InventoryReceivingNote.class, id);
	}
	
	public void updateIRN(InventoryReceivingNote irn) {
		if(irn.getIRNDetail()!=null) {
			for(IRNDetail irnDetail: irn.getIRNDetail()) {
				irnDetail.setInventory_receiving_note(irn);
			}
		}
		this.sessionFactory.getCurrentSession().update(irn);
	}
	
	public void deleteIRN(int id) {
		InventoryReceivingNote irn = this.getIRN(id);
		this.sessionFactory.getCurrentSession().delete(irn);
	}
	
	
	public List<InventoryReceivingNote> searchIRN(InventoryReceivingNote irn){
		List<InventoryReceivingNote> irnList = this.sessionFactory.getCurrentSession()
				.createQuery("from InventoryReceivingNote where id= :id or staff= :staff or date= :date")
				.setParameter("id", irn.getId())
				.setParameter("staff", irn.getStaff().getId())
				.setParameter("date", irn.getDate())
				.setDate("date", irn.getDate())
				.list();
		return irnList;
	}
	
	public List<InventoryReceivingNote> getAllIRNsByDates(Date startDate, Date endDate) {
		 
		 return this.sessionFactory.getCurrentSession()
				 .createQuery("from InventoryReceivingNote where  date >= :startDate and date <= :endDate")
				 .setDate("startDate", startDate)
	             .setDate("endDate", endDate)
	             .list();
	}
}
