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
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.Carton;
import com.uslc.po.jpa.entity.PurchaseOrderDetail;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="packing_detail", uniqueConstraints={@UniqueConstraint(columnNames={"sku", "purchase_order_detail_id", "deleted"})})
@NamedQuery(name="PackingDetail.findAll", query="SELECT p FROM PackingDetail p")
public class PackingDetail
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="deleted")
    private boolean deleted;
    @Column(name="quantity")
    private int quantity;
    @Column(name="SKU")
    private int sku;
    @ManyToOne
    @JoinColumn(name="purchase_order_detail_id")
    private PurchaseOrderDetail purchaseOrderDetail;
    @OneToOne(mappedBy="packingDetail")
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

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSku() {
        return this.sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public PurchaseOrderDetail getPurchaseOrderDetail() {
        return this.purchaseOrderDetail;
    }

    public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.purchaseOrderDetail = purchaseOrderDetail;
    }

    public Carton getCarton() {
        return this.carton;
    }

    public void setCarton(Carton carton) {
        this.carton = carton;
    }
}

