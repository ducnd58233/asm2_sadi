package com.sadi.asm2.model.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.sadi.asm2.model.Order.InventoryDeliveryNote;
import com.sadi.asm2.model.Order.InventoryReceivingNote;
import com.sadi.asm2.model.Order.Orders;
import com.sadi.asm2.model.Order.SaleInvoice;


@Entity
@Table(name="staff")
public class Staff extends Person {	
	@OneToMany(targetEntity=Orders.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Orders> orders = new HashSet();
	
	@OneToMany(targetEntity=SaleInvoice.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<SaleInvoice> sale_invoice = new HashSet();
	
	@OneToMany(targetEntity=InventoryReceivingNote.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<InventoryReceivingNote> inventory_receiving_note = new HashSet();
	
	@OneToMany(targetEntity=InventoryDeliveryNote.class, mappedBy="staff", cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<InventoryDeliveryNote> inventory_delivery_note = new HashSet();
	
	public Staff() {}
	
	public Staff(String name,String address,String phone,String email)
	{
		super(name, address, phone, email);
	}
	
	public Staff(int id,String name,String address,String phone,String email)
	{
		super(id, name, address, phone, email);
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<SaleInvoice> getSale_invoice() {
		return sale_invoice;
	}

	public void setSale_invoice(Set<SaleInvoice> sale_invoice) {
		this.sale_invoice = sale_invoice;
	}

	public Set<InventoryReceivingNote> getInventory_receiving_note() {
		return inventory_receiving_note;
	}

	public void setInventory_receiving_note(Set<InventoryReceivingNote> inventory_receiving_note) {
		this.inventory_receiving_note = inventory_receiving_note;
	}

	public Set<InventoryDeliveryNote> getInventory_delivery_note() {
		return inventory_delivery_note;
	}

	public void setInventory_delivery_note(Set<InventoryDeliveryNote> inventory_delivery_note) {
		this.inventory_delivery_note = inventory_delivery_note;
	}

	
	
	
	
}
