/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityTransaction
 *  javax.persistence.Query
 */
package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.entity.PurchaseOrder;
import com.uslc.po.jpa.util.UslcJpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PurchaseOrderRepo {
    private static UslcJpa jpa = null;

    public static List<PurchaseOrder> findAll() {
        Query q = PurchaseOrderRepo.getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.deleted=:deleted ORDER BY po.referenceNumber DESC");
        q.setParameter("deleted", (Object)false);
        return q.getResultList();
    }

    public static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static String getLastReferenceNumber() {
        String ref = "";
        Query q = PurchaseOrderRepo.getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.deleted=:deleted ORDER BY po.referenceNumber DESC");
        q.setMaxResults(1);
        q.setParameter("deleted", (Object)false);
        List list = q.getResultList();
        if (list != null && list.size() > 0) {
            ref = ((PurchaseOrder)list.get(0)).getReferenceNumber();
        }
        return ref;
    }

    public static int getNextId() {
        int nextId;
        nextId = 0;
        PurchaseOrder po = new PurchaseOrder();
        po.setDeleted(false);
        po.setDepartmentNumber("");
        po.setReferenceNumber("");
        po.setShipFrom("");
        po.setShipTo("");
        po.setTotalCartons(0);
        po.setTotalItems(0);
        EntityTransaction trans = null;
        EntityManager em = null;
        try {
            try {
                em = PurchaseOrderRepo.getJpa().getEntityManager();
                nextId = po.getId();
                trans = em.getTransaction();
                trans.begin();
                em.persist((Object)po);
                em.flush();
            }
            catch (Exception e) {
                try {
                    trans.rollback();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    trans.rollback();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    em.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        finally {
            try {
                trans.rollback();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                em.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nextId;
    }

    public static PurchaseOrder createPurchaseOrder(PurchaseOrder po) throws Exception {
        if (!PurchaseOrderRepo.getJpa().persist(po)) {
            throw new Exception("there was a problem creating the puchase order");
        }
        return po;
    }

    public static PurchaseOrder findPOByRefNumber(String referenceNumber) {
        PurchaseOrder po = null;
        Query q = PurchaseOrderRepo.getJpa().getEntityManager().createQuery("SELECT po FROM PurchaseOrder po WHERE po.referenceNumber=:referenceNumber AND po.deleted=:deleted");
        q.setParameter("deleted", (Object)false);
        q.setParameter("referenceNumber", (Object)referenceNumber);
        q.setMaxResults(1);
        List list = q.getResultList();
        if (list.size() > 0) {
            po = (PurchaseOrder)list.get(0);
        }
        return po;
    }
}

