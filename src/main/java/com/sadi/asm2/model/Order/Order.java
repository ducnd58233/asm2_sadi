package com.sadi.asm2.model.Order;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String date;
	
	@Column
	private int saleInvoice = 0;
	
	@Column
	private int staffId;
	
	@Column
	private int providerId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSaleInvoice() {
		return saleInvoice;
	}

	public void setSaleInvoice(int saleInvoice) {
		this.saleInvoice = saleInvoice;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	
	
	
	
}
