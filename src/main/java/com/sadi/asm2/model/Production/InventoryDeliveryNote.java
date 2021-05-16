package com.sadi.asm2.model.Production;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "inventory_delivery_note")
public class InventoryDeliveryNote extends NoteDetails{
	public InventoryDeliveryNote() { super(); }
	
	public InventoryDeliveryNote(int productId, int staffId, int quantity) {
		super(productId, staffId, quantity);
	}
	
	public InventoryDeliveryNote(int productId, int staffId, int quantity, Date date) {
		super(productId, staffId, quantity, date);
	}
	
	public InventoryDeliveryNote(int id, int productId, int staffId, int quantity, Date date) {
		super(id, productId, staffId, quantity, date);
	}
}
