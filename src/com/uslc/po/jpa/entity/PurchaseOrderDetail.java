/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.NamedQuery
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.PackingDetail;
import com.uslc.po.jpa.entity.PurchaseOrder;
import com.uslc.po.jpa.entity.Upc;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="purchase_order_detail")
@NamedQuery(name="PurchaseOrderDetail.findAll", query="SELECT p FROM PurchaseOrderDetail p")
public class PurchaseOrderDetail
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean deleted;
    private boolean preticketed;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date timestamp;
    private int total;
    @OneToMany(mappedBy="purchaseOrderDetail")
    private List<PackingDetail> packingDetails;
    @ManyToOne
    @JoinColumn(name="purchase_order_id")
    private PurchaseOrder purchaseOrder;
    @ManyToOne
    private Upc upc;

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

    public boolean getPreticketed() {
        return this.preticketed;
    }

    public void setPreticketed(boolean preticketed) {
        this.preticketed = preticketed;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PackingDetail> getPackingDetails() {
        return this.packingDetails;
    }

    public void setPackingDetails(List<PackingDetail> packingDetails) {
        this.packingDetails = packingDetails;
    }

    public PackingDetail addPackingDetail(PackingDetail packingDetail) {
        this.getPackingDetails().add(packingDetail);
        packingDetail.setPurchaseOrderDetail(this);
        return packingDetail;
    }

    public PackingDetail removePackingDetail(PackingDetail packingDetail) {
        this.getPackingDetails().remove(packingDetail);
        packingDetail.setPurchaseOrderDetail(null);
        return packingDetail;
    }

    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Upc getUpc() {
        return this.upc;
    }

    public void setUpc(Upc upc) {
        this.upc = upc;
    }
}

