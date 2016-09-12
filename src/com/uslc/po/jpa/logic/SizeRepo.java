/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.Query
 */
package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.entity.Size;
import com.uslc.po.jpa.util.UslcJpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SizeRepo {
    private static UslcJpa jpa = null;

    public static List<Size> findAll() {
        Query q = SizeRepo.getJpa().getEntityManager().createQuery("SELECT s FROM Size s");
        return q.getResultList();
    }

    private static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static Size findByWaistInstream(String waistInseam) {
        Size size = null;
        Query q = SizeRepo.getJpa().getEntityManager().createQuery("SELECT s FROM Size s WHERE CONCAT(S.waist,'x',s.inseam) = :sizexinseam");
        q.setParameter("sizexinseam", (Object)waistInseam);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            size = (Size)items.get(0);
        }
        return size;
    }

    public static Size findByWaist(int waist) {
        Size size = null;
        Query q = SizeRepo.getJpa().getEntityManager().createQuery("SELECT s FROM Size s WHERE s.waist=:waist AND s.inseam=:inseam");
        q.setParameter("waist", (Object)waist);
        q.setParameter("inseam", (Object)36);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            size = (Size)items.get(0);
        }
        return size;
    }

    public static Size createSize(Size size) throws Exception {
        size = (Size)SizeRepo.getJpa().merge(size);
        if (size == null) {
            throw new Exception("there was a problem persisting the size");
        }
        return size;
    }
}

