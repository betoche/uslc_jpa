package com.uslc.po.jpa.comparator;

import java.util.Collections;
import java.util.Comparator;

import com.uslc.po.jpa.entity.PurchaseOrderDetail;

public class PurchaseOrderDetailComparator implements Comparator<PurchaseOrderDetail> {

	@Override
	public int compare(PurchaseOrderDetail o1, PurchaseOrderDetail o2) {
		Collections.sort( o1.getPackingDetails(), new PackageDetailComparator() );
		Collections.sort( o2.getPackingDetails(), new PackageDetailComparator() );
		//getLog().info( o1.getPackingDetails().get(o1.getPackingDetails().size()-1).getSku() + " - " + o2.getPackingDetails().get(0).getSku() );
		return o1.getPackingDetails().get(0).getSku() - o2.getPackingDetails().get(0).getSku();
	}
	
}
