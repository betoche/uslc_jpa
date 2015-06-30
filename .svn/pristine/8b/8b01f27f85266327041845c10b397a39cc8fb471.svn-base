package com.uslc.po.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.uslc.po.jpa.entity.Size;

public class JPATester {
	private static final String PERSISTENCE_UNIT_NAME = "uslc_po";
	

	public static void main(String[] args) {
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();

	    // Begin a new local transaction so that we can persist a new entity
	    em.getTransaction().begin();

	    // read the existing entries
	    Query q = em.createQuery("select s from Size s");
	    
	 // do we have entries?
	    boolean createNewEntries = (q.getResultList().size() == 0);

	    // No, so lets create new entries
	    if (createNewEntries) {
	    	Size size = new Size();
	    	size.setWaist(30);
	    	size.setHip(32);
	    	size.setInseam(32);
	    	em.persist( size );
	    	
	    	em.getTransaction().commit();
	    	em.close();
	    }else{
	    	List<Size> sizes = q.getResultList();
	    	for (Size size : sizes) {
	    		System.out.println( size );
			}
	    }
	}
}