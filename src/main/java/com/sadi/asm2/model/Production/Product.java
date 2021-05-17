package com.sadi.asm2.model.Production;

import javax.persistence.*;


@Entity
@Table(name="product")
public class Product {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String model;
	
	@Column
	private String brand;
	
	@Column
	private String company;
	
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="category_id",referencedColumnName="id",nullable=false,unique=false)
    private Category category;
	
	@Column
	private int price;
	
	public Product() { super(); }
	
//	public Product(int id, String name, String model, String brand, String company, String description, int categoryId, int price) {
//		this.id = id;
//		this.name = name;
//		this.model = model;
//		this.brand = brand;
//		this.company = company;
//		this.description = description;
//		this.setCategory((Catego));
//		this.price = price;
//	}
	
	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}
