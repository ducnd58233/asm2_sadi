package com.sadi.asm2.model.Order;

import javax.persistence.*;


@Entity
public class OrderDetail {
	@Id
	private int orderId;
	
	@Column
	private int price;
	
	@Column
	private int productId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	private Order order;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
