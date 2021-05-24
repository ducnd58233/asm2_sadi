package com.sadi.asm2.service.Statistic;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Order.OrderDetail;
import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.model.Production.Product;

@Service
@Transactional
public class StatisticService {
	@Autowired
    private SessionFactory sessionFactory;

    public StatisticService(){}

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    // Get generic revenue.
    public double getRevenue(){
        // String query = "select SUM(quantity * price) from OrderDetail"
        List<OrderDetail> orderDetailsList = this.sessionFactory.getCurrentSession()
                                                .createQuery("from OrderDetail").list();
        return sumRevenue(orderDetailsList);
    }

    // Broken mapping, cannot find any related to customer in order/order detail.
    public double getRevenueByCustomer(int providerId){
    	 double revenue = 0.0;
    	Query query = sessionFactory.getCurrentSession().createQuery("from Orders where providerId=:id");
        query.setInteger("id", providerId);
        List<Orders> orderList = (List<Orders>) query.list();
        
        for(Orders o : orderList){        	
        	query = sessionFactory.getCurrentSession().createQuery("from OrderDetail where orderId=:id");
            query.setInteger("id", o.getId());
            List<OrderDetail> orderDetailsList = (List<OrderDetail>) query.list();
            
            for(OrderDetail od : orderDetailsList){
                revenue += od.getQuantity() * od.getPrice();
            }
        	
            
        }

        return revenue;
    }

    // Calculate revenue by staff
    public double getRevenueByStaff(int staffId){
        
        double revenue = 0.0;
    	Query query = sessionFactory.getCurrentSession().createQuery("from Orders where staffId=:id");
        query.setInteger("id", staffId);
        List<Orders> orderList = (List<Orders>) query.list();
        
        for(Orders o : orderList){        	
        	query = sessionFactory.getCurrentSession().createQuery("from OrderDetail where orderId=:id");
            query.setInteger("id", o.getId());
            List<OrderDetail> orderDetailsList = (List<OrderDetail>) query.list();
            
            for(OrderDetail od : orderDetailsList){
                revenue += od.getQuantity() * od.getPrice();
            }
        	
            
        }

        return revenue;
    }

    // Revenue based on start date and end date
    public double getRevenueInPeriod(Date startDate, Date endDate){
    	   double revenue = 0.0;
        List<Orders> orderList = this.sessionFactory.getCurrentSession()
                .createQuery("from Orders  " + 
                        "where date >= :startDate and date <= :endDate")
                .setDate("startDate", startDate)
                .setDate("endDate", endDate)
                .list();
        for(Orders o : orderList){        	
        	Query query = sessionFactory.getCurrentSession().createQuery("from OrderDetail where orderId=:id");
            query.setInteger("id", o.getId());
            List<OrderDetail> orderDetailsList = (List<OrderDetail>) query.list();
            
            for(OrderDetail od : orderDetailsList){
                revenue += od.getQuantity() * od.getPrice();
            }
        	
            
        }  return revenue;
    }

    // Inventory of all products in warehouse at a particular date.
    public List<Product> getWarehouseProducts(Date date){
        return this.sessionFactory.getCurrentSession()
                .createQuery("from Product d inner join InventoryReceivingNote irn " +
                        "on d.id = irn.productId and irn.date = :date")
                .setDate("date", date)
                .list();
    }

    private double sumRevenue(List<OrderDetail> orderDetailList){
        double revenue = 0.0;

        for(com.sadi.asm2.model.Order.OrderDetail od : orderDetailList){
            revenue += od.getQuantity() * od.getPrice();
        }

        return revenue;
    }
}
