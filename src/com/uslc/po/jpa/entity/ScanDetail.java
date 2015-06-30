package com.uslc.po.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scan_detail database table.
 * 
 */
@Entity
@Table(name="scan_detail")
@NamedQuery(name="ScanDetail.findAll", query="SELECT s FROM ScanDetail s")
public class ScanDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private boolean deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp")
	private Date timestamp;

	@ManyToOne
	@JoinColumn(name="upc_id")
	private Upc upc;

	@Column(name="upc_reference_number")
	private String upcReferenceNumber;

	//bi-directional many-to-one association to Carton
	@ManyToOne
	@JoinColumn(name="carton_id")
	private Carton carton;

	public ScanDetail() {
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

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Upc getUpc() {
		return this.upc;
	}

	public void setUpc(Upc upc) {
		this.upc = upc;
	}

	public String getUpcReferenceNumber() {
		return this.upcReferenceNumber;
	}

	public void setUpcReferenceNumber(String upcReferenceNumber) {
		this.upcReferenceNumber = upcReferenceNumber;
	}

	public Carton getCarton() {
		return this.carton;
	}

	public void setCarton(Carton carton) {
		this.carton = carton;
	}

}