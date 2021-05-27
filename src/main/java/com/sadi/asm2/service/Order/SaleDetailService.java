package com.sadi.asm2.service.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.SaleInvoiceDetail;

@Service
@Transactional
public class SaleDetailService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SaleInvoiceDetail createSaleInvoiceDetail(SaleInvoiceDetail saleInvoiceDetail) {
		this.sessionFactory.getCurrentSession().save(saleInvoiceDetail);
		return saleInvoiceDetail;
	}
	
	public SaleInvoiceDetail getSaleInvoiceDetail(int id) {
		return this.sessionFactory.getCurrentSession().get(SaleInvoiceDetail.class, id);
	}
	
	public List<SaleInvoiceDetail> getAllSaleInvoiceDetails(){
		return this.sessionFactory.getCurrentSession().createQuery("from SaleInvoiceDetail").list();
	}
	
	public void updateSaleInvoiceDetail(SaleInvoiceDetail saleInvoiceDetail) {
		this.sessionFactory.getCurrentSession().update(saleInvoiceDetail);
	}
	
	public void deleteSaleInvoiceDetail(int id) {
		SaleInvoiceDetail saleInvoiceDetail = this.getSaleInvoiceDetail(id);
		this.sessionFactory.getCurrentSession().delete(saleInvoiceDetail);
	}
	
	public List<SaleInvoiceDetail> searchSaleInvoiceDetail(SaleInvoiceDetail saleInvoiceDetail) {
		 List<SaleInvoiceDetail> saleInvoiceDetailList = this.sessionFactory.getCurrentSession()
					.createQuery("from SaleInvoiceDetail where id=:id or product=:product or productId=:productId or quantity=:quantity  or price=:price or saleInvoiceId=:saleInvoiceId") 
					 .setInteger("id", saleInvoiceDetail.getId())
					 .setInteger("productId", saleInvoiceDetail.getProduct().getId())
					 .setString("product", saleInvoiceDetail.getProduct().getName())
					 .setInteger("quantity", saleInvoiceDetail.getQuantity()) 
					 .setInteger("price", saleInvoiceDetail.getPrice())
					 .setInteger("saleInvoiceId", saleInvoiceDetail.getSaleInvoice().getId())					
					.list();
			
			return saleInvoiceDetailList;
	}
	
    
    public List<SaleInvoiceDetail> getAllPaginatedSaleInvoiceDetails(int startRecord, int maxRecords) {
    	Session session =  this.sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(SaleInvoiceDetail.class);
    	criteria.setFirstResult(startRecord);
        criteria.setMaxResults(maxRecords); 
		return  (List) criteria.list();
	}
}
