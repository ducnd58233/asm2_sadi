package com.sadi.asm2.service.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.InventoryDeliveryNote;

@Service
@Transactional
public class IDNService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public InventoryDeliveryNote createIDN(InventoryDeliveryNote idn) {
		this.sessionFactory.getCurrentSession().save(idn);
		return idn;
	}
	
	public List<InventoryDeliveryNote> getAllIDNs(){
		return this.sessionFactory.getCurrentSession().createQuery("from InventoryDeliveryNote").list();
	}
	
	public InventoryDeliveryNote getIDN(int id) {
		return this.sessionFactory.getCurrentSession().get(InventoryDeliveryNote.class, id);
	}
	
	public void updateIDN(InventoryDeliveryNote idn) {
		this.sessionFactory.getCurrentSession().update(idn);
	}
	
	public void deleteIDN(int id) {
		InventoryDeliveryNote idn = this.getIDN(id);
		this.sessionFactory.getCurrentSession().delete(idn);
	}
	
	
	public List<InventoryDeliveryNote> searchIDN(InventoryDeliveryNote idn){
		List<InventoryDeliveryNote> idnList = this.sessionFactory.getCurrentSession()
				.createQuery("from InventoryDeliveryNote where id= :id or staffId= :staffId or providerId= :providerId or date= :date")
				.setParameter("id", idn.getId())
				.setParameter("staffId", idn.getStaffId())
				.setParameter("productId", idn.getProductId())
//				.setParameter("staff", irn.getStaff().getName())
//				.setParameter("provider", irn.getProvider().getName())
				.setParameter("date", idn.getDate())
				.list();
		return idnList;
	}
	
	public List<InventoryDeliveryNote> getAllIDNsByDates(Date startDate, Date endDate) {
		 
		 return this.sessionFactory.getCurrentSession()
				 .createQuery("from InventoryDeliveryNote where  date >= :startDate and date <= :endDate")
				 .setParameter("startDate", startDate)
	             .setParameter("endDate", endDate)
	             .list();
	}
}
