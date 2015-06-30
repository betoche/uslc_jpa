package com.uslc.po.jpa.logic;

public enum Actions {
	LOGIN( 1, Forms.LOGIN, "Just loging." ), EXIT(2, Forms.MASTER, "just exiting the application");
	
	private int id = 0;
	private Forms form = null;
	private String action = "";
	
	private Actions( int id, Forms form, String action ){
		this.id = id;
		this.form = form;
		this.action = action;
	}
	
	public int getId(){
		return id;
	}
	public Forms getForm(){
		return form;
	}
	public String getAction(){
		return action;
	}
	
	public static Actions getAction( int id ){
		Actions a = null;
		for (Actions action : Actions.values()) {
			if( id == action.getId() ){
				a = action;
				break;
			}
		}
		return a;
	}
}
