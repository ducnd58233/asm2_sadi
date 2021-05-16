package com.sadi.asm2.model.Production;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class NoteDetails {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int productId;
	
	@Column
	private int staffId;
	
	@Column
	private int quantity;
	
	@Column
	private Date date;
	
	public NoteDetails() { super(); }
	
	public NoteDetails(int productId, int staffId, int quantity) {
		this.productId = productId;
		this.staffId = staffId;
		this.quantity = quantity;
	}
	
	public NoteDetails(int productId, int staffId, int quantity, Date date) {
		this.productId = productId;
		this.staffId = staffId;
		this.quantity = quantity;
		this.date = date;
	}
	
	public NoteDetails(int id, int productId, int staffId, int quantity, Date date) {
		this.id = id;
		this.productId = productId;
		this.staffId = staffId;
		this.quantity = quantity;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
