package com.sadi.asm2.model.Order;

import javax.persistence.*;

import com.sadi.asm2.model.Person.Provider;
import com.sadi.asm2.model.Person.Staff;


@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String date;
	
	@OneToOne(mappedBy="orders")
	private OrderDetail orderDetail;

	@ManyToOne
	@JoinColumn (name="staff_id",referencedColumnName="id",nullable=false,unique=false)
	private Staff staff;
	
	@ManyToOne
	@JoinColumn (name="provider_id",referencedColumnName="id",nullable=false,unique=false)
	private Provider provider;
	
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	

}
