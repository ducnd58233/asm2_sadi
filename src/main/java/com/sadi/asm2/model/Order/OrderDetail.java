package com.sadi.asm2.model.Order;

import javax.persistence.*;

import com.sadi.asm2.model.Production.Product;


@Entity
@Table(name="order_detail")
public class OrderDetail {
	@Id
    private int id;
	 
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id", nullable = false)
	private Product product;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
	@JoinColumn (name="order_id",referencedColumnName="id",nullable=false,unique=false)
    private Orders orders;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
}
