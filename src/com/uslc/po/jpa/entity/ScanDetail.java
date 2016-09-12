/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.NamedQuery
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.Carton;
import com.uslc.po.jpa.entity.Upc;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="scan_detail")
@NamedQuery(name="ScanDetail.findAll", query="SELECT s FROM ScanDetail s")
public class ScanDetail
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private boolean deleted;
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="timestamp")
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name="upc_id")
    private Upc upc;
    @Column(name="upc_reference_number")
    private String upcReferenceNumber;
    @ManyToOne
    @JoinColumn(name="carton_id")
    private Carton carton;

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

