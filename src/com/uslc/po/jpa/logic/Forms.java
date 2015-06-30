package com.uslc.po.jpa.logic;

public enum Forms {
	LOGIN(1), MASTER(2);
	
	private int id = 0;
	
	private Forms( int id ){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public static Forms getForm( int id ){
		Forms f = null;
		for (Forms form : Forms.values()) {
			if( id == form.getId() ){
				f = form;
				break;
			}
		}
		return f;
	}
}
