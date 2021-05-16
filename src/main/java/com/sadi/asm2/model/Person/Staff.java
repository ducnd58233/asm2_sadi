package com.sadi.asm2.model.Person;

import javax.persistence.*;


@Entity
@Table(name="staff")
public class Staff extends Person {	
	public Staff() {}
	
	public Staff(String name,String address,String phone,String email)
	{
		super(name, address, phone, email);
	}
	
	public Staff(int id,String name,String address,String phone,String email)
	{
		super(id, name, address, phone, email);
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
	
	
	
}
