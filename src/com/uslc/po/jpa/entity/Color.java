package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@Table(name="color")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String number;

	//bi-directional many-to-one association to Upc
	@OneToMany(mappedBy="color")
	private List<Upc> upcs;

	public Color() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Upc> getUpcs() {
		return this.upcs;
	}

	public void setUpcs(List<Upc> upcs) {
		this.upcs = upcs;
	}

	public Upc addUpc(Upc upc) {
		getUpcs().add(upc);
		upc.setColor(this);

		return upc;
	}

	public Upc removeUpc(Upc upc) {
		getUpcs().remove(upc);
		upc.setColor(null);

		return upc;
	}

}