package com.uslc.po.jpa.util;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.persistence.jpa.JpaEntityManager;

public class UslcJpa {
	private static final String PERSISTENCE_UNIT_NAME = "uslc_po";
	private Map<String, String> properties = null;
	private EntityManagerFactory factory = null;
	private EntityManager em = null;
	private Logger log = null;
	
	public UslcJpa() {
	}
	public UslcJpa( Map<String,String> properties ){
		this.properties = properties;
	}
	public void refresh( Object obj ){
		//getEntityManager().flush();
		//getEntityManager().getEntityManagerFactory().getCache().evict( obj.getClass(), obj );
		try{getEntityManager().refresh(obj);}catch(Exception e){}
	}
	public EntityManagerFactory getFactory(){
		if( factory == null ){
			if( properties!=null ) {
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties );
			}else {
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME );
			}
		}
		return factory;
	}
	public void evictAll(){
		getEntityManager().getEntityManagerFactory().getCache().evictAll();
		((JpaEntityManager)getEntityManager().getDelegate()).getServerSession().getIdentityMapAccessor().initializeAllIdentityMaps();
		getEntityManager().clear();
	}
	public EntityManager getEntityManager() throws PersistenceException{
		if( em == null || !em.isOpen() ){
			em = getFactory().createEntityManager();
		}
		return em;
	}
	public boolean persist( Object obj ) throws Exception{
		boolean success = false;
		
		EntityTransaction trans = null;
		try{
			trans = getEntityManager().getTransaction();
			trans.begin();
			getEntityManager().merge(obj);
			trans.commit();
			success = true;
		}catch( Exception e ){
			if(trans.isActive() ) trans.rollback();
			getLog().error( "error persisting object", e );
			throw e;
		}finally{
			getEntityManager().close();
		}
		
		return success;
	}
	
	public Object merge( Object obj ) throws Exception {
		EntityTransaction trans = null;
		try{
			trans = getEntityManager().getTransaction();
			trans.begin();
			obj = getEntityManager().merge(obj);
			trans.commit();
		}catch( Exception e ){
			if(trans.isActive())trans.rollback();	
			getLog().error( "error merging object", e );
			throw e;
		}finally{
			getEntityManager().close();
		}
		
		return obj;
	}
	
	private Logger getLog(){
		if( log == null ){
			log = Logger.getLogger( UslcJpa.class );
			PropertyConfigurator.configure( "log4j.properties" );
		}
		return log;
	}
}