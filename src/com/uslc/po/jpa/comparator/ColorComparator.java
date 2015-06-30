package com.uslc.po.jpa.comparator;

import java.util.Comparator;

import com.uslc.po.jpa.entity.Color;

public class ColorComparator implements Comparator<Color>{

	@Override
	public int compare(Color o1, Color o2) {
		return o1.getName().compareTo( o2.getName() );
	}

}
