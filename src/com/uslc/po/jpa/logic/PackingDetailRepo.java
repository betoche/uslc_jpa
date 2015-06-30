package com.uslc.po.jpa.logic;

import java.util.List;

import javax.persistence.Query;

import com.uslc.po.jpa.entity.PackingDetail;
import com.uslc.po.jpa.entity.PurchaseOrderDetail;
import com.uslc.po.jpa.util.UslcJpa;

public class PackingDetailRepo {
	private static UslcJpa jpa = null;
	
	public static List<PackingDetail> findAll(){
		Query q = getJpa().getEntityManager().createQuery("SELECT pd FROM PackingDetail pd");
	    return (List<PackingDetail>)q.getResultList();
	}
	public static List<PackingDetail> findByPurchaseOrderDetail( PurchaseOrderDetail pod ) throws Exception{
		String query = "SELECT pd FROM PackingDetail pd WHERE pd.purchaseOrderDetail=:purchaseOrderDetail";
		Query q = null;
		try{
			q = getJpa().getEntityManager().createQuery(query);
			q.setParameter("purchaseOrderDetail", pod);
		}catch( Exception e ){
			//e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return (List<PackingDetail>)q.getResultList();
	}
	private static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	public static PackingDetail createPackingDetail(int itemsInCarton, int sku, PurchaseOrderDetail pod) throws Exception {
		PackingDetail pd = null;
		
		try{
			pd = new PackingDetail();
			pd.setPurchaseOrderDetail(pod);
			pd.setQuantity(itemsInCarton);
			pd.setSku(sku);
			
			if( getJpa().persist( pd ) ){
				throw new Exception("there was a problem trying to ad the packing detail");
			}
		}catch( Exception e ){
			throw new Exception(e.getMessage());
		}
		
		return pd;
	}
}
