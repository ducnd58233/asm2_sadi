package com.sadi.asm2.model.Person;

import java.util.List;

import javax.persistence.*;

import com.sadi.asm2.model.Order.Orders;


@Entity
@Table(name="staff")
public class Staff extends Person {	
	@OneToMany(mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Orders> orders;
	
	
	public Staff() {}
	
	public Staff(String name,String address,String phone,String email)
	{
		super(name, address, phone, email);
	}
	
	public Staff(int id,String name,String address,String phone,String email)
	{
		super(id, name, address, phone, email);
	}

	
	
	
	
}
