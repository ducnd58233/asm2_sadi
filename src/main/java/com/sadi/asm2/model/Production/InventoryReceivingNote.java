package com.sadi.asm2.model.Production;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "inventory_receiving_note")
public class InventoryReceivingNote extends NoteDetails{
	public InventoryReceivingNote() { super(); }
	
	public InventoryReceivingNote(int productId, int staffId, int quantity) {
		super(productId, staffId, quantity);
	}
	
	public InventoryReceivingNote(int productId, int staffId, int quantity, Date date) {
		super(productId, staffId, quantity, date);
	}
	
	public InventoryReceivingNote(int id, int productId, int staffId, int quantity, Date date) {
		super(id, productId, staffId, quantity, date);
	}
	
	
}
