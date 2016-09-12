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
@Table(name="size")
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int hip;
    private int inseam;
    private int waist;
    @OneToMany(mappedBy="size")
    private List<Upc> upcs;

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
        this.getUpcs().add(upc);
        upc.setSize(this);
        return upc;
    }

    public Upc removeUpc(Upc upc) {
        this.getUpcs().remove(upc);
        upc.setSize(null);
        return upc;
    }
}

