/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.NamedQuery
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.Upc;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="code")
    private String code;
    @OneToMany(mappedBy="item")
    private List<Upc> upcs;

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
        this.getUpcs().add(upc);
        upc.setItem(this);
        return upc;
    }

    public Upc removeUpc(Upc upc) {
        this.getUpcs().remove(upc);
        upc.setItem(null);
        return upc;
    }
}

