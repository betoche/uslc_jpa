/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.Query
 *  org.apache.log4j.Logger
 *  org.apache.log4j.PropertyConfigurator
 */
package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.entity.Color;
import com.uslc.po.jpa.util.UslcJpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ColorRepo {
    private static UslcJpa jpa = null;
    private static Logger log = null;

    public static List<Color> findAll() {
        Query q = ColorRepo.getJpa().getEntityManager().createQuery("SELECT c FROM Color c");
        return q.getResultList();
    }

    private static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static Color findByNumber(String colorNumber) {
        Color color = null;
        Query q = ColorRepo.getJpa().getEntityManager().createQuery("SELECT c FROM Color c WHERE c.number = :number");
        q.setParameter("number", (Object)colorNumber);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            color = (Color)items.get(0);
        }
        return color;
    }

    public static Color createColor(Color color) throws Exception {
        color = (Color)ColorRepo.getJpa().merge(color);
        if (color == null) {
            throw new Exception("there was a problem persisting the color");
        }
        return color;
    }

    private static Logger getLog() {
        if (log == null) {
            log = Logger.getLogger((Class)ColorRepo.class);
            PropertyConfigurator.configure((String)"log4j.properties");
        }
        return log;
    }
}

