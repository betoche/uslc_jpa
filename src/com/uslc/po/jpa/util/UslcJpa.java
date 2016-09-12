/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.EntityTransaction
 *  javax.persistence.Persistence
 *  javax.persistence.PersistenceException
 *  org.apache.log4j.Logger
 *  org.apache.log4j.PropertyConfigurator
 */
package com.uslc.po.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UslcJpa {
    private static final String PERSISTENCE_UNIT_NAME = "uslc_po";
    private EntityManagerFactory factory = null;
    private EntityManager em = null;
    private Logger log = null;

    public void refresh(Object obj) {
        try {
            this.getEntityManager().refresh(obj);
        }
        catch (Exception var2_2) {
            // empty catch block
        }
    }

    public EntityManagerFactory getFactory() {
        if (this.factory == null) {
            this.factory = Persistence.createEntityManagerFactory((String)"uslc_po");
        }
        return this.factory;
    }

    public EntityManager getEntityManager() throws PersistenceException {
        if (this.em == null || !this.em.isOpen()) {
            this.em = this.getFactory().createEntityManager();
        }
        return this.em;
    }

    public boolean persist(Object obj) throws Exception {
        boolean success;
        success = false;
        EntityTransaction trans = null;
        try {
            try {
                trans = this.getEntityManager().getTransaction();
                trans.begin();
                this.getEntityManager().merge(obj);
                trans.commit();
                success = true;
            }
            catch (Exception e) {
                if (trans.isActive()) {
                    trans.rollback();
                }
                this.getLog().error((Object)"error persisting object", (Throwable)e);
                throw e;
            }
        }
        finally {
            this.getEntityManager().close();
        }
        return success;
    }

    public Object merge(Object obj) throws Exception {
        boolean success = false;
        EntityTransaction trans = null;
        try {
            try {
                trans = this.getEntityManager().getTransaction();
                trans.begin();
                obj = this.getEntityManager().merge(obj);
                trans.commit();
                success = true;
            }
            catch (Exception e) {
                if (trans.isActive()) {
                    trans.rollback();
                }
                this.getLog().error((Object)"error merging object", (Throwable)e);
                throw e;
            }
        }
        finally {
            this.getEntityManager().close();
        }
        return obj;
    }

    private Logger getLog() {
        if (this.log == null) {
            this.log = Logger.getLogger((Class)UslcJpa.class);
            PropertyConfigurator.configure((String)"log4j.properties");
        }
        return this.log;
    }
}

