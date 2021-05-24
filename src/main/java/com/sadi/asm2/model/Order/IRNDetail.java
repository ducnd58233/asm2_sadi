package com.sadi.asm2.model.Order;

import javax.persistence.*;


@Entity
@Table(name="irn_detail")
public class IRNDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="irn_id",referencedColumnName="id",nullable=false,unique=false)
    private InventoryReceivingNote inventory_receiving_note;
	
	@Column
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InventoryReceivingNote getInventory_receiving_note() {
		return inventory_receiving_note;
	}

	public void setInventory_receiving_note(InventoryReceivingNote inventory_receiving_note) {
		this.inventory_receiving_note = inventory_receiving_note;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
