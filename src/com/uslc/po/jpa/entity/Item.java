package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="code")
	private String code;

	//bi-directional many-to-one association to Upc
	@OneToMany(mappedBy="item")
	private List<Upc> upcs;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Upc> getUpcs() {
		return this.upcs;
	}

	public void setUpcs(List<Upc> upcs) {
		this.upcs = upcs;
	}

	public Upc addUpc(Upc upc) {
		getUpcs().add(upc);
		upc.setItem(this);

		return upc;
	}

	public Upc removeUpc(Upc upc) {
		getUpcs().remove(upc);
		upc.setItem(null);

		return upc;
	}

}