package com.sadi.asm2.service.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.OrderDetail;
import com.sadi.asm2.model.Order.SaleInvoice;
import com.sadi.asm2.model.Order.SaleInvoiceDetail;

@Service
@Transactional
public class SaleService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SaleInvoice createSaleInvoice(SaleInvoice saleInvoice) {
		this.sessionFactory.getCurrentSession().save(saleInvoice);
		return saleInvoice;
	}
	
	public SaleInvoice getSaleInvoice(int id) {
		return this.sessionFactory.getCurrentSession().get(SaleInvoice.class, id);
	}
	
	public List<SaleInvoice> getAllSaleInvoice(){
		return this.sessionFactory.getCurrentSession().createQuery("from SaleInvoice").list();
	}
	
	public void updateSaleInvoice(SaleInvoice saleInvoice) {
		if(saleInvoice.getSaleInvoiceDetail()!=null) {
			for(SaleInvoiceDetail saleInvoiceDetail: saleInvoice.getSaleInvoiceDetail()) {
				saleInvoiceDetail.setSaleInvoice(saleInvoice);
			}
		}
		this.sessionFactory.getCurrentSession().update(saleInvoice);
	}
	
	public void deleteSaleInvoice(int id) {
		SaleInvoice saleInvoice = this.getSaleInvoice(id);
		this.sessionFactory.getCurrentSession().delete(saleInvoice);
	}
	
	public List<SaleInvoice> searchSaleInvoice(SaleInvoice saleInvoice) {
		 List<SaleInvoice> salesList = this.sessionFactory.getCurrentSession()
					.createQuery("from SaleInvoice where id=:id or staffName=:staffName or staffId=:staffId or customerId=:customerId  or quantity=:quantity or total=:total or date=:date") 
					 .setParameter("id", saleInvoice.getId())
					 .setParameter("staffId", saleInvoice.getStaff().getId())
					 .setParameter("staffName", saleInvoice.getStaff().getName())
					 .setParameter("customerId", saleInvoice.getCustomer().getId()) 
					 .setParameter("total", saleInvoice.getTotal())
					 .setDate("date", saleInvoice.getDate()) 
					.list();
			
			return salesList;
	}
	
	public List<SaleInvoice> getAllSaleInvoices(Date startDate, Date endDate){
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from SaleInvoice where date >= :startDate and date <= :endDate")
                .setDate("startDate", startDate)
                .setDate("endDate", endDate)
                .list();
    }

    public List<SaleInvoice> getAllSaleInvoices(int customerId, int staffId, Date startDate, Date endDate){
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from SaleInvoice " +
                        "where date >= :startDate and date <= :endDate " +
                        "and customerId = :customerId " +
                        "and staffId = :staffId")
                .setDate("startDate", startDate)
                .setDate("endDate", endDate)
                .list();
    }

    
    public List<SaleInvoice> getAllPaginatedSaleInvoices(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(SaleInvoice.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords); 
		return  (List) criteria.list();
	}
    
	
}
