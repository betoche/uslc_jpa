package com.uslc.po.jpa.logic;

import java.util.List;

import javax.persistence.Query;

import com.uslc.po.jpa.entity.Item;
import com.uslc.po.jpa.util.UslcJpa;

public class ItemRepo {
	private static UslcJpa jpa = null;
	
	public static List<Item> findAll(){
		Query q = getJpa().getEntityManager().createQuery("SELECT i FROM Item i");
	    return (List<Item>)q.getResultList();
	}
	private static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	public static Item findByCode(String itemCode) {
		Item item = null;
		Query q = getJpa().getEntityManager().createQuery("SELECT i FROM Item i WHERE i.code = :code");
		q.setParameter("code", itemCode);
		q.setMaxResults(1);
		
		List<Item> items = (List<Item>)q.getResultList();
		
		if( items!=null && items.size()>0 ){
			item = items.get(0);
		}
		
	    return item;
	}
	public static Item createItem(Item item) throws Exception {
		item = (Item)getJpa().merge(item);
		if( item==null ){
			throw new Exception( "there was a problem persisting the item" );
		}
		return item;
	}
}
