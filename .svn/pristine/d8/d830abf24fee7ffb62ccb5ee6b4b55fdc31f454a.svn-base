package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@Table(name="size")
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int hip;

	private int inseam;

	private int waist;

	//bi-directional many-to-one association to Upc
	@OneToMany(mappedBy="size")
	private List<Upc> upcs;

	public Size() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHip() {
		return this.hip;
	}

	public void setHip(int hip) {
		this.hip = hip;
	}

	public int getInseam() {
		return this.inseam;
	}

	public void setInseam(int inseam) {
		this.inseam = inseam;
	}

	public int getWaist() {
		return this.waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}

	public List<Upc> getUpcs() {
		return this.upcs;
	}

	public void setUpcs(List<Upc> upcs) {
		this.upcs = upcs;
	}

	public Upc addUpc(Upc upc) {
		getUpcs().add(upc);
		upc.setSize(this);

		return upc;
	}

	public Upc removeUpc(Upc upc) {
		getUpcs().remove(upc);
		upc.setSize(null);

		return upc;
	}

}