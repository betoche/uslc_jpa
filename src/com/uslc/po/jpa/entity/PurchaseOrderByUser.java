package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the purchase_order_by_user database table.
 * 
 */
@Entity
@Table(name="purchase_order_by_user", uniqueConstraints={@UniqueConstraint(columnNames={"purchase_order_id","user_id"})})
@NamedQuery(name="PurchaseOrderByUser.findAll", query="SELECT p FROM PurchaseOrderByUser p")
public class PurchaseOrderByUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="deleted")
	private boolean deleted;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="purchase_order_id")
	private PurchaseOrder purchaseOrder;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public PurchaseOrderByUser() {
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

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}