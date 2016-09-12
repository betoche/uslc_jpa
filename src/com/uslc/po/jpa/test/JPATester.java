/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.EntityTransaction
 *  javax.persistence.Persistence
 *  javax.persistence.Query
 */
package com.uslc.po.jpa.test;

import com.uslc.po.jpa.entity.Size;
import java.io.PrintStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATester {
    private static final String PERSISTENCE_UNIT_NAME = "uslc_po";

    public static void main(String[] args) {
        boolean createNewEntries;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory((String)"uslc_po");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select s from Size s");
        boolean bl = createNewEntries = q.getResultList().size() == 0;
        if (createNewEntries) {
            Size size = new Size();
            size.setWaist(30);
            size.setHip(32);
            size.setInseam(32);
            em.persist((Object)size);
            em.getTransaction().commit();
            em.close();
        } else {
            List sizes = q.getResultList();
            for (Size size : sizes) {
                System.out.println(size);
            }
        }
    }
}

