/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.comparator;

import com.uslc.po.jpa.entity.PackingDetail;
import java.util.Comparator;

public class PackageDetailComparator
implements Comparator<PackingDetail> {
    @Override
    public int compare(PackingDetail o1, PackingDetail o2) {
        return o1.getSku() - o2.getSku();
    }
}

