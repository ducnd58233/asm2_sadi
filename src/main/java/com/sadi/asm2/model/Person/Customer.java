package com.sadi.asm2.model.Person;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends Person{
	@Column
	private String fax;
	
	@Column
	private String contact_person;
	
	public Customer() {};
	
	public Customer(String name,String address,String phone,String email, 
			String fax, String contact_person)
	{
		super(name, address, phone, email);
		this.fax = fax;
		this.contact_person = contact_person;
	}

	
	public Customer(int id,String name,String address,String phone,String email, 
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
