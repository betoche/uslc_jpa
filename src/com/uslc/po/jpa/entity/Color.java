/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="color")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String number;
    @OneToMany(mappedBy="color")
    private List<Upc> upcs;

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
        this.getUpcs().add(upc);
        upc.setColor(this);
        return upc;
    }

    public Upc removeUpc(Upc upc) {
        this.getUpcs().remove(upc);
        upc.setColor(null);
        return upc;
    }
}

