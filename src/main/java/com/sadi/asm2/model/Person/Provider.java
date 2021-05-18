package com.sadi.asm2.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Order.Orders;

@Entity
@Table(name = "provider")
public class Provider extends Person{
	@Column
	private String fax;
	
	@Column
	private String contact_person;
	
	@OneToMany(targetEntity=Orders.class, mappedBy="provider", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Orders> orders = new HashSet();
	
	
	public Provider() {};
	
	public Provider(String name,String address,String phone,String email, 
			String fax, String contact_person)
	{
		super(name, address, phone, email);
		this.fax = fax;
		this.contact_person = contact_person;
	}
	
	public Provider(int id,String name,String address,String phone,String email, 
			String fax, String contact_person)
	{
		super(id, name, address, phone, email);
		this.fax = fax;
		this.contact_person = contact_person;
	}

	// Setters and Getters
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	
}
