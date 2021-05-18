package com.sadi.asm2.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.model.Order.SaleInvoice;


@Entity
@Table(name="staff")
public class Staff extends Person {	
	@OneToMany(targetEntity=Orders.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Orders> orders = new HashSet();
	
	@OneToMany(targetEntity=SaleInvoice.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<SaleInvoice> sale_invoice = new HashSet();
	
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
