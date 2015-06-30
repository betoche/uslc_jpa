package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the packing_detail database table.
 * 
 */
@Entity
@Table(name="packing_detail", uniqueConstraints={@UniqueConstraint(columnNames={"sku","purchase_order_detail_id","deleted"})})
@NamedQuery(name="PackingDetail.findAll", query="SELECT p FROM PackingDetail p")
public class PackingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="deleted")
	private boolean deleted;

	@Column(name="quantity")
	private int quantity;

	@Column(name="SKU")
	private int sku;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@ManyToOne
	@JoinColumn(name="purchase_order_detail_id")
	private PurchaseOrderDetail purchaseOrderDetail;

	//bi-directional one-to-one association to Carton
	@OneToOne(mappedBy="packingDetail")
	private Carton carton;

	public PackingDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSku() {
		return this.sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return this.purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public Carton getCarton() {
		return this.carton;
	}

	public void setCarton(Carton carton) {
		this.carton = carton;
	}

}