package com.sadi.asm2.model.Order;

import java.util.Date;
import java.util.HashSet;
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
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn (name="staff_id",referencedColumnName="id",nullable=false,unique=false)
	private Staff staff;
	
	@ManyToOne
	@JoinColumn (name="customer_id",referencedColumnName="id",nullable=false,unique=false)
	private Customer customer;	
	
	@Column
    private int total;
	
	@OneToMany(targetEntity=SaleInvoiceDetail.class, mappedBy="sale_invoice", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<SaleInvoiceDetail> SaleInvoiceDetail  = new HashSet();
	
	@OneToOne(fetch = FetchType.EAGER)
    private InventoryDeliveryNote idn;
	

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

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Set<SaleInvoiceDetail> getSaleInvoiceDetail() {
		return SaleInvoiceDetail;
	}

	public void setSaleInvoiceDetail(Set<SaleInvoiceDetail> saleInvoiceDetail) {
		SaleInvoiceDetail = saleInvoiceDetail;
	}

	public InventoryDeliveryNote getIdn() {
		return idn;
	}

	public void setIdn(InventoryDeliveryNote idn) {
		this.idn = idn;
	}

    
}
