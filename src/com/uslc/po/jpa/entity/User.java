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
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package com.uslc.po.jpa.entity;

import com.uslc.po.jpa.entity.Log;
import com.uslc.po.jpa.entity.PurchaseOrderByUser;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="enabled")
    private boolean enabled;
    @Column(name="active")
    private boolean active;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String password;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name="user_type")
    private int userType;
    private String username;
    @OneToMany(mappedBy="user")
    private List<Log> logs;
    @OneToMany(mappedBy="user")
    private List<PurchaseOrderByUser> purchaseOrders = null;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Log> getLogs() {
        return this.logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public Log addLog(Log log) {
        this.getLogs().add(log);
        log.setUser(this);
        return log;
    }

    public Log removeLog(Log log) {
        this.getLogs().remove(log);
        log.setUser(null);
        return log;
    }

    public List<PurchaseOrderByUser> getPurchaseOrders() {
        return this.purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrderByUser> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public PurchaseOrderByUser addpurchaseOrder(PurchaseOrderByUser purchaseOrder) {
        this.getPurchaseOrders().add(purchaseOrder);
        purchaseOrder.setUser(this);
        return purchaseOrder;
    }

    public PurchaseOrderByUser removePurchaseOrders(PurchaseOrderByUser purchaseOrder) {
        this.getPurchaseOrders().remove(purchaseOrder);
        purchaseOrder.setUser(null);
        return purchaseOrder;
    }
}

