package com.sadi.asm2.model.Order;

import javax.persistence.*;

@Entity
@Table(name = "sale_invoice_detail")
public class SaleInvoiceDetail {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="sale_invoice_id")
//	private SaleInvoice saleInvoice;
}
