/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Lob
 *  javax.persistence.NamedQuery
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.PurchaseOrderByUser;
import com.uslc.po.jpa.entity.PurchaseOrderDetail;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="purchase_order", uniqueConstraints={@UniqueConstraint(columnNames={"deleted", "reference_number"})})
@NamedQuery(name="PurchaseOrder.findAll", query="SELECT p FROM PurchaseOrder p")
public class PurchaseOrder
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="deleted")
    private boolean deleted;
    @Column(name="department_number")
    private String departmentNumber;
    @Column(name="reference_number")
    private String referenceNumber;
    @Lob
    @Column(name="ship_from")
    private String shipFrom;
    @Lob
    @Column(name="ship_to")
    private String shipTo;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name="total_cartons")
    private int totalCartons;
    @Column(name="total_items")
    private int totalItems;
    @OneToMany(mappedBy="purchaseOrder")
    private List<PurchaseOrderDetail> purchaseOrderDetails;
    @OneToMany(mappedBy="purchaseOrder")
    private List<PurchaseOrderByUser> purchaseOrders = null;

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

    public String getDepartmentNumber() {
        return this.departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getShipFrom() {
        return this.shipFrom;
    }

    public void setShipFrom(String shipFrom) {
        this.shipFrom = shipFrom;
    }

    public String getShipTo() {
        return this.shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotalCartons() {
        return this.totalCartons;
    }

    public void setTotalCartons(int totalCartons) {
        this.totalCartons = totalCartons;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return this.purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public PurchaseOrderDetail addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.getPurchaseOrderDetails().add(purchaseOrderDetail);
        purchaseOrderDetail.setPurchaseOrder(this);
        return purchaseOrderDetail;
    }

    public PurchaseOrderDetail removePurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.getPurchaseOrderDetails().remove(purchaseOrderDetail);
        purchaseOrderDetail.setPurchaseOrder(null);
        return purchaseOrderDetail;
    }

    public List<PurchaseOrderByUser> getPurchaseOrders() {
        return this.purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrderByUser> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public PurchaseOrderByUser addpurchaseOrder(PurchaseOrderByUser purchaseOrder) {
        this.getPurchaseOrders().add(purchaseOrder);
        purchaseOrder.setPurchaseOrder(this);
        return purchaseOrder;
    }

    public PurchaseOrderByUser removePurchaseOrders(PurchaseOrderByUser purchaseOrder) {
        this.getPurchaseOrders().remove(purchaseOrder);
        purchaseOrder.setPurchaseOrder(null);
        return purchaseOrder;
    }
}

