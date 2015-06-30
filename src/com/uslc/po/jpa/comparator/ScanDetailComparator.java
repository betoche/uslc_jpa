package com.uslc.po.jpa.comparator;

import java.util.Comparator;

import com.uslc.po.jpa.entity.ScanDetail;

public class ScanDetailComparator implements Comparator<ScanDetail> {

	@Override
	public int compare(ScanDetail o1, ScanDetail o2) {
		return (int)( o1.getTimestamp().getTime() - o2.getTimestamp().getTime() );
	}

}
