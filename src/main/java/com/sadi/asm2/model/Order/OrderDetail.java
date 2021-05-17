package com.sadi.asm2.model.Order;

import javax.persistence.*;


@Entity
public class OrderDetail {
	@Id
	private int id;
	
	@Column
	private int price;
	
	@Column
	private int productId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Orders getOrder() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}
	
	
}
