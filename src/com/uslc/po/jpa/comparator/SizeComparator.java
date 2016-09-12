/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.comparator;

import com.uslc.po.jpa.entity.Size;
import java.util.Comparator;

public class SizeComparator
implements Comparator<Size> {
    @Override
    public int compare(Size o1, Size o2) {
        int comparison = 0;
        comparison = o1.getWaist() - o2.getWaist();
        if (comparison != 0) {
            return comparison;
        }
        comparison = o1.getInseam() - o2.getInseam();
        if (comparison != 0) {
            return comparison;
        }
        return 0;
    }
}

