package com.sadi.asm2.model.Order;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Person.Customer;
import com.sadi.asm2.model.Person.Staff;


@Entity
@Table(name = "sale_invoice")
public class SaleInvoice {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="staff_id",referencedColumnName="id",nullable=false,unique=false)
	private Staff staff;
	
	@ManyToOne
	@JoinColumn (name="customer_id",referencedColumnName="id",nullable=false,unique=false)
	private Customer customer;	
	
//	@OneToOne(mappedBy="sale_invoice")
//	private SaleInvoiceDetail saleInvoiceDetail;

	@Column
	private Date date;

	
	public SaleInvoice() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setProvider(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    
}
