package com.sadi.asm2.model.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Person.Staff;

@Entity
@Table(name = "inventory_delivery_note")
public class InventoryDeliveryNote{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
    private Date date;

    @ManyToOne
	@JoinColumn (name="staff_id",referencedColumnName="id",nullable=false,unique=false)
	private Staff staff;

    @OneToMany(targetEntity=IDNDetail.class, mappedBy="inventory_delivery_note", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<IDNDetail> IDNDetail  = new HashSet();
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set<IDNDetail> getIDNDetail() {
		return IDNDetail;
	}

	public void setIDNDetail(Set<IDNDetail> iDNDetail) {
		IDNDetail = iDNDetail;
	}

	
    
    
}
