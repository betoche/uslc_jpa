package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.entity.PurchaseOrderDetail;
import com.uslc.po.jpa.entity.Upc;
import com.uslc.po.jpa.util.UslcJpa;

public class PurchaseOrderDetailRepo {
	private static UslcJpa jpa = null;
	
	private static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	
	public static PurchaseOrderDetail createPurchaseOrderDetail( boolean preticketed, int total,
			com.uslc.po.jpa.entity.PurchaseOrder po, Upc upc) throws Exception {
		PurchaseOrderDetail pod = null;
		
		try{
			pod = new PurchaseOrderDetail();
			pod.setDeleted(true);
			pod.setPreticketed(preticketed);
			pod.setPurchaseOrder(po);
			pod.setTotal(total);
			pod.setUpc(upc);
			
			if( !getJpa().persist( pod ) ){
				throw new Exception( "there was a problem creating the purchase order detail" );
			}
		}catch( Exception e ){
			e.printStackTrace();
			throw new Exception( e.getMessage() );
		}
		
		return pod;
	}
	public static void setDeleted( PurchaseOrderDetail pod, boolean deleted ) throws Exception{
		if( !getJpa().persist(pod) ){
			throw new Exception( "there was a problem updating the purchase order detail" );
		}
	}
}
