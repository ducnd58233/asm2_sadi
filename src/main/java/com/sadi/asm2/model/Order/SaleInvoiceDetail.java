package com.sadi.asm2.model.Order;

import javax.persistence.*;

import com.sadi.asm2.model.Production.Product;

@Entity
@Table(name = "sale_invoice_detail")
public class SaleInvoiceDetail {
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
	@JoinColumn (name="sale_invoice_id",referencedColumnName="id",nullable=false,unique=false)
    private SaleInvoice sale_invoice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SaleInvoice getSaleInvoice() {
		return sale_invoice;
	}

	public void setSaleInvoice(SaleInvoice sale_invoice) {
		this.sale_invoice = sale_invoice;
	}
    
    
}
