package com.uslc.po.jpa.comparator;

import java.util.Comparator;

import com.uslc.po.jpa.entity.Size;

public class SizeComparator implements Comparator<Size> {

	@Override
	public int compare(Size o1, Size o2) {
		int comparison = 0;
		comparison = o1.getWaist() - o2.getWaist();
		if( comparison != 0 )
			return comparison;
			
		comparison = o1.getInseam() - o2.getInseam();
		if( comparison!=0 )
			return comparison;
		
		return 0;
	}

}
