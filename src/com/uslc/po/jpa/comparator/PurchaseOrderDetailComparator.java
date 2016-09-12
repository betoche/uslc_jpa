/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.comparator;

import com.uslc.po.jpa.comparator.PackageDetailComparator;
import com.uslc.po.jpa.entity.PackingDetail;
import com.uslc.po.jpa.entity.PurchaseOrderDetail;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PurchaseOrderDetailComparator
implements Comparator<PurchaseOrderDetail> {
    @Override
    public int compare(PurchaseOrderDetail o1, PurchaseOrderDetail o2) {
        Collections.sort(o1.getPackingDetails(), new PackageDetailComparator());
        Collections.sort(o2.getPackingDetails(), new PackageDetailComparator());
        return o1.getPackingDetails().get(0).getSku() - o2.getPackingDetails().get(0).getSku();
    }
}

