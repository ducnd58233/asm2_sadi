package com.sadi.asm2.model.Production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(int id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	
	// Getters and Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
