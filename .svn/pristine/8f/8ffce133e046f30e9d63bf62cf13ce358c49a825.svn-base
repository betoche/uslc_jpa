package com.uslc.po.jpa.logic;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.uslc.po.jpa.entity.Color;
import com.uslc.po.jpa.util.UslcJpa;

public class ColorRepo {
	private static UslcJpa jpa = null;
	private static Logger log = null;
	
	public static List<Color> findAll(){
		Query q = getJpa().getEntityManager().createQuery("SELECT c FROM Color c");
	    return (List<Color>)q.getResultList();
	}
	private static UslcJpa getJpa(){
		if( jpa == null ){
			jpa = new UslcJpa();
		}
		return jpa;
	}
	public static Color findByNumber(String colorNumber) {
		Color color = null;
		Query q = getJpa().getEntityManager().createQuery("SELECT c FROM Color c WHERE c.number = :number");
		q.setParameter("number", colorNumber);
		q.setMaxResults(1);
		
		List<Color> items = (List<Color>)q.getResultList();
		
		if( items!=null && items.size()>0 ){
			color = items.get(0);
		}
		return color;
	}
	public static Color createColor( Color color ) throws Exception {
		color = (Color)getJpa().merge( color );
		if( color==null ){
			throw new Exception( "there was a problem persisting the color" );
		}
		return color;
	}
	private static Logger getLog(){
		if( log == null ){
			log = Logger.getLogger( ColorRepo.class );
			PropertyConfigurator.configure( "log4j.properties" );
		}
		return log;
	}
}
