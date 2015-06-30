package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the upc database table.
 * 
 */
@Entity
@Table(name="upc")
@NamedQuery(name="Upc.findAll", query="SELECT u FROM Upc u")
public class Upc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="color_item_code")
	private String colorItemCode;

	private boolean deleted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="upc_code")
	private String upcCode;

	//bi-directional many-to-one association to PurchaseOrderDetail
	@OneToMany(mappedBy="upc")
	private List<PurchaseOrderDetail> purchaseOrderDetails;

	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;

	//bi-directional many-to-one association to Size
	@ManyToOne
	@JoinColumn(name="size_id")
	private Size size;

	public Upc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColorItemCode() {
		return this.colorItemCode;
	}

	public void setColorItemCode(String colorItemCode) {
		this.colorItemCode = colorItemCode;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUpcCode() {
		return this.upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().add(purchaseOrderDetail);
		purchaseOrderDetail.setUpc(this);

		return purchaseOrderDetail;
	}

	public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		getPurchaseOrderDetails().remove(purchaseOrderDetail);
		purchaseOrderDetail.setUpc(null);

		return purchaseOrderDetail;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}