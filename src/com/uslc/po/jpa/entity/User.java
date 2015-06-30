package com.uslc.po.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@Column(name="active", nullable=false)
	private boolean active;

	@Column(name="first_name", nullable=false)
	private String firstName;

	@Column(name="last_name", nullable=false)
	private String lastName;

	@Column(name="password", nullable=false)
	private String password;

	@Column(name="timestamp", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="user_type", nullable=false)
	private int userType;

	@Column(name="username", nullable=false)
	private String username;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
	private List<Log> logs;
	@OneToMany(mappedBy="user")
	private List<PurchaseOrderByUser> purchaseOrders = null;

	public User() {
	}

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
		if( firstName.isEmpty() ) {
			return;
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		if( lastName.isEmpty() ) {
			return;
		}
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		if( password.trim().isEmpty() ) {
			return;
		}
		System.out.println( "password set to ["+password+"]" );
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
		if( username.trim().isEmpty() ) {
			return;
		}
		System.out.println( "username set to ["+username+"]" );
		this.username = username;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setUser(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
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
		getPurchaseOrders().add(purchaseOrder);
		purchaseOrder.setUser(this);

		return purchaseOrder;
	}

	public PurchaseOrderByUser removePurchaseOrders(PurchaseOrderByUser purchaseOrder) {
		getPurchaseOrders().remove(purchaseOrder);
		purchaseOrder.setUser(null);

		return purchaseOrder;
	}

}