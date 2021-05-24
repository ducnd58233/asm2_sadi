package com.sadi.asm2.model.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="idn_detail")
public class IDNDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="idn_id",referencedColumnName="id",nullable=false,unique=false)
    private InventoryDeliveryNote inventory_delivery_note;
	
	@Column
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InventoryDeliveryNote getInventory_delivery_note() {
		return inventory_delivery_note;
	}

	public void setInventory_delivery_note(InventoryDeliveryNote inventory_delivery_note) {
		this.inventory_delivery_note = inventory_delivery_note;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
