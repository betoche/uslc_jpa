package com.uslc.po.jpa.logic;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.uslc.po.jpa.entity.Color;
import com.uslc.po.jpa.entity.Item;
import com.uslc.po.jpa.entity.Size;
import com.uslc.po.jpa.entity.Upc;
import com.uslc.po.jpa.util.UslcJpa;

public class UpcRepo {
	private static UslcJpa jpa = null;
	private static Logger log = null;
	
	public static List<Upc> findAll(){
		Query q = getJpa().getEntityManager().createQuery("SELECT u FROM Upc u ORDER BY u.deleted, u.upcCode ASC");
	    return (List<Upc>)q.getResultList();
	}
	private static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	public static Upc findByItemSizeColor(Item item, Size size, Color color) {
		Upc upc = null;
		Query q = getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.item = :item AND u.size = :size AND u.color = :color AND u.deleted = :deleted ORDER BY u.upcCode");
		q.setParameter( "item", item );
		q.setParameter( "size", size );
		q.setParameter( "color", color );
		q.setParameter( "deleted", false );
		q.setMaxResults(1);

		List<Upc> items = (List<Upc>)q.getResultList();
		
		if( items!=null && items.size()>0 ){
			upc = items.get(0);
		}else{
			try{
				getLog().error( "SELECT u FROM Upc u WHERE u.item = :item AND u.size = :size AND u.color = :color AND u.deleted = :deleted\n"
						+ item.getId() + "item["+item.getCode()+"]\n"
						+ size.getId() + "size["+size.getWaist()+"x"+size.getInseam()+"]\n"
						+ color.getId() + "color["+color.getNumber()+"]" );
			}catch( Exception e ){
				
			}
		}
		
		return upc;
	}
	
	private static Logger getLog(){
		if( log == null ){
			log = Logger.getLogger( UpcRepo.class );
			PropertyConfigurator.configure( "log4j.properties" );
		}
		return log;
	}
	public static Upc findByCode(String upcCode) {
		Upc upc = null;
		Query q = getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.upcCode = :upcCode AND u.deleted = :deleted");
		q.setParameter( "upcCode", upcCode );
		q.setParameter( "deleted", false );
		q.setMaxResults(1);

		List<Upc> items = (List<Upc>)q.getResultList();
		
		if( items!=null && items.size()>0 ){
			upc = items.get(0);
		}
		
		return upc;
	}
	public static Upc createUpc(Upc upc) throws Exception {
		try{
			getJpa().refresh( upc.getColor() );
			getJpa().refresh( upc.getItem() );
			getJpa().refresh( upc.getSize() );
			getJpa().refresh( upc );
		}catch( Exception e ){
		}
		upc = (Upc)getJpa().merge(upc);
		if( upc==null ){
			throw new Exception( "there was a problem persisting the item" );
		}else{
			getLog().info( "new upc.getId(" + upc.getId() + ")" );
		}
		return upc;
	}
	public static List<Upc> findByItem(Item item) {
		Query q = getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.item = :item AND u.deleted = :deleted ORDER BY u.upcCode ASC");
		q.setParameter( "item", item );
		q.setParameter( "deleted", false );

		return (List<Upc>)q.getResultList();
	}
	public static List<Upc> findByItemAndInseam(Item item, int inseam) {
		Query q = getJpa().getEntityManager().createQuery("SELECT u FROM Upc u JOIN u.size s WHERE u.item=:item AND s.inseam=:inseam AND u.deleted=:deleted ORDER BY u.upcCode ASC");
		q.setParameter( "item", item );
		q.setParameter( "inseam", inseam);
		q.setParameter( "deleted", false );

		return (List<Upc>)q.getResultList();
	}
}
