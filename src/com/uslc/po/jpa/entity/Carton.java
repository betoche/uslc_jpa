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
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.PackingDetail;
import com.uslc.po.jpa.entity.ScanDetail;
import com.uslc.po.jpa.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carton")
@NamedQuery(name="Carton.findAll", query="SELECT c FROM Carton c")
public class Carton
implements Serializable {
    private static final long serialVersionUID = 1;
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
    @OneToOne
    @JoinColumn(name="packing_detail_id")
    private PackingDetail packingDetail;
    @OneToMany(mappedBy="carton")
    private List<ScanDetail> scanDetails;

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
        this.getScanDetails().add(scanDetail);
        scanDetail.setCarton(this);
        return scanDetail;
    }

    public ScanDetail removeScanDetail(ScanDetail scanDetail) {
        this.getScanDetails().remove(scanDetail);
        scanDetail.setCarton(null);
        return scanDetail;
    }
}

