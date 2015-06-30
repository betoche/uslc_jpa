package com.uslc.po.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carton database table.
 * 
 */
@Entity
@Table(name="carton")
@NamedQuery(name="Carton.findAll", query="SELECT c FROM Carton c")
public class Carton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="completed")
	private boolean completed;

	@Column(name="deleted")
	private boolean deleted;

	@Column(name="items")
	private int items;

	@Column(name="reference_number")
	private String referenceNumber;

	@Column(name="upc_code")
	private String upcCode;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional one-to-one association to PackingDetail
	@OneToOne
	@JoinColumn(name="packing_detail_id")
	private PackingDetail packingDetail;

	//bi-directional many-to-one association to ScanDetail
	@OneToMany(mappedBy="carton")
	private List<ScanDetail> scanDetails;

	public Carton() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getItems() {
		return this.items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getUpcCode() {
		return this.upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public User getUserId() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PackingDetail getPackingDetail() {
		return this.packingDetail;
	}

	public void setPackingDetail(PackingDetail packingDetail) {
		this.packingDetail = packingDetail;
	}

	public List<ScanDetail> getScanDetails() {
		return this.scanDetails;
	}

	public void setScanDetails(List<ScanDetail> scanDetails) {
		this.scanDetails = scanDetails;
	}

	public ScanDetail addScanDetail(ScanDetail scanDetail) {
		getScanDetails().add(scanDetail);
		scanDetail.setCarton(this);

		return scanDetail;
	}

	public ScanDetail removeScanDetail(ScanDetail scanDetail) {
		getScanDetails().remove(scanDetail);
		scanDetail.setCarton(null);

		return scanDetail;
	}

}