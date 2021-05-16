package com.sadi.asm2.model.Production;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Order.Order;


@Entity
@Table(name = "sale_invoice")
public class SaleInvoice {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int staffId;
	
	@Column
	private String staffName;
	
	@Column
	private int customerId;
	
	@Column
	private String customerName;
	
	@Column
	private int quantity;
	
	@Column
	private int total;
	
	@Column
	private Date date;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="saleInvoice")
	private Set<Order> orders;
	
	public SaleInvoice() {
    }

	public SaleInvoice(int staffId, int customerId, int quantity, int total, Date date) {
        this.staffId = staffId;
        this.customerId = customerId; 
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }
	
    public SaleInvoice(int id, int staffId, int customerId, int quantity, int total, Date date) {
        this.id = id;
        this.staffId = staffId;
        this.customerId = customerId; 
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
    
    

    
}
