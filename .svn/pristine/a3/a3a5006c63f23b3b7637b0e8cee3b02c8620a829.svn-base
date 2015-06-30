package com.uslc.po.jpa.logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.uslc.po.jpa.entity.PurchaseOrder;
import com.uslc.po.jpa.util.UslcJpa;

public class PurchaseOrderRepo {
	private static UslcJpa jpa = null;
	
	public static List<PurchaseOrder> findAll(){
		Query q = getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.deleted=:deleted ORDER BY po.referenceNumber DESC");
		q.setParameter("deleted", false);
	    return (List<PurchaseOrder>)q.getResultList();
	}
	public static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	public static String getLastReferenceNumber(){
		String ref = "";
		
		Query q = getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.deleted=:deleted ORDER BY po.referenceNumber DESC");
		q.setMaxResults(1);
		q.setParameter("deleted", false);
		List<PurchaseOrder> list = (List<PurchaseOrder>)q.getResultList();
		if( list!=null && list.size()>0 ){
			ref = list.get(0).getReferenceNumber();
		}
		
		return ref;
	}
	public static int getNextId() {
		int nextId = 0;
		com.uslc.po.jpa.entity.PurchaseOrder po = new com.uslc.po.jpa.entity.PurchaseOrder();
		po.setDeleted(false);
		po.setDepartmentNumber("");
		po.setReferenceNumber("");
		po.setShipFrom("");
		po.setShipTo("");
		po.setTotalCartons(0);
		po.setTotalItems(0);
		
		EntityTransaction trans = null;
		EntityManager em = null;
		try{
			em = getJpa().getEntityManager();
			
			nextId = po.getId();
			trans = em.getTransaction();
			trans.begin();
			
			em.persist(po);
			em.flush();
		}catch( Exception e ){
			try{trans.rollback();}catch(Exception ex){ex.printStackTrace();}
		}finally{
			try{trans.rollback();}catch(Exception e){e.printStackTrace();}
			try{em.close();}catch(Exception e){e.printStackTrace();}
		}
		
		return nextId;
	}
	public static PurchaseOrder createPurchaseOrder( PurchaseOrder po) throws Exception {
		if( !getJpa().persist(po) ) {
			throw new Exception( "there was a problem creating the puchase order" );
		}

		return po;
	}
	public static PurchaseOrder findPOByRefNumber(String referenceNumber) {
		PurchaseOrder po = null;
		
		Query q = getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.referenceNumber=:referenceNumber AND po.deleted=:deleted");
		q.setParameter("deleted", false);
		q.setParameter("referenceNumber", referenceNumber);
		q.setMaxResults(1);
		
		List<PurchaseOrder> list = (List<PurchaseOrder>)q.getResultList();
	    if(list.size()>0){
	    	po = list.get(0);
	    }
		return po;
	}
}
