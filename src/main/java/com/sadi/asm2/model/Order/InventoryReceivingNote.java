package com.sadi.asm2.model.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Person.Staff;

@Entity
@Table(name = "inventory_receiving_note")
public class InventoryReceivingNote{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column
    private Date date;

    @ManyToOne
	@JoinColumn (name="staff_id",referencedColumnName="id",nullable=false,unique=false)
	private Staff staff;

    @OneToOne(fetch = FetchType.EAGER)
    private Orders orders;
    
    @OneToMany(targetEntity=IRNDetail.class, mappedBy="inventory_receiving_note", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<IRNDetail> IRNDetail  = new HashSet();
    

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<IRNDetail> getIRNDetail() {
		return IRNDetail;
	}

	public void setIRNDetail(Set<IRNDetail> iRNDetail) {
		this.IRNDetail = iRNDetail;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
    
}
