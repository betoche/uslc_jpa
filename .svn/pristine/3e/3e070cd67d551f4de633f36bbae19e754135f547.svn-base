package com.uslc.po.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchase_order_detail database table.
 * 
 */
@Entity
@Table(name="purchase_order_detail")
@NamedQuery(name="PurchaseOrderDetail.findAll", query="SELECT p FROM PurchaseOrderDetail p")
public class PurchaseOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private boolean deleted;

	private boolean preticketed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	private int total;

	//bi-directional many-to-one association to PackingDetail
	@OneToMany(mappedBy="purchaseOrderDetail")
	private List<PackingDetail> packingDetails;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="purchase_order_id")
	private PurchaseOrder purchaseOrder;

	//bi-directional many-to-one association to Upc
	@ManyToOne
	private Upc upc;

	public PurchaseOrderDetail() {
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

	public boolean getPreticketed() {
		return this.preticketed;
	}

	public void setPreticketed(boolean preticketed) {
		this.preticketed = preticketed;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<PackingDetail> getPackingDetails() {
		return this.packingDetails;
	}

	public void setPackingDetails(List<PackingDetail> packingDetails) {
		this.packingDetails = packingDetails;
	}

	public PackingDetail addPackingDetail(PackingDetail packingDetail) {
		getPackingDetails().add(packingDetail);
		packingDetail.setPurchaseOrderDetail(this);

		return packingDetail;
	}

	public PackingDetail removePackingDetail(PackingDetail packingDetail) {
		getPackingDetails().remove(packingDetail);
		packingDetail.setPurchaseOrderDetail(null);

		return packingDetail;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Upc getUpc() {
		return this.upc;
	}

	public void setUpc(Upc upc) {
		this.upc = upc;
	}

}