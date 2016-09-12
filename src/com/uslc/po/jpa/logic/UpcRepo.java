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
import com.uslc.po.jpa.entity.Item;
import com.uslc.po.jpa.entity.Size;
import com.uslc.po.jpa.entity.Upc;
import com.uslc.po.jpa.util.UslcJpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UpcRepo {
    private static UslcJpa jpa = null;
    private static Logger log = null;

    public static List<Upc> findAll() {
        Query q = UpcRepo.getJpa().getEntityManager().createQuery("SELECT u FROM Upc u ORDER BY u.deleted, u.upcCode ASC");
        return q.getResultList();
    }

    private static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static Upc findByItemSizeColor(Item item, Size size, Color color) {
        Upc upc = null;
        Query q = UpcRepo.getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.item = :item AND u.size = :size AND u.color = :color AND u.deleted = :deleted ORDER BY u.upcCode");
        q.setParameter("item", (Object)item);
        q.setParameter("size", (Object)size);
        q.setParameter("color", (Object)color);
        q.setParameter("deleted", (Object)false);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            upc = (Upc)items.get(0);
        } else {
            try {
                UpcRepo.getLog().error((Object)("SELECT u FROM Upc u WHERE u.item = :item AND u.size = :size AND u.color = :color AND u.deleted = :deleted\n" + item.getId() + "item[" + item.getCode() + "]\n" + size.getId() + "size[" + size.getWaist() + "x" + size.getInseam() + "]\n" + color.getId() + "color[" + color.getNumber() + "]"));
            }
            catch (Exception var6_6) {
                // empty catch block
            }
        }
        return upc;
    }

    private static Logger getLog() {
        if (log == null) {
            log = Logger.getLogger((Class)UpcRepo.class);
            PropertyConfigurator.configure((String)"log4j.properties");
        }
        return log;
    }

    public static Upc findByCode(String upcCode) {
        Upc upc = null;
        Query q = UpcRepo.getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.upcCode = :upcCode AND u.deleted = :deleted");
        q.setParameter("upcCode", (Object)upcCode);
        q.setParameter("deleted", (Object)false);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            upc = (Upc)items.get(0);
        }
        return upc;
    }

    public static Upc createUpc(Upc upc) throws Exception {
        try {
            UpcRepo.getJpa().refresh(upc.getColor());
            UpcRepo.getJpa().refresh(upc.getItem());
            UpcRepo.getJpa().refresh(upc.getSize());
            UpcRepo.getJpa().refresh(upc);
        }
        catch (Exception var1_1) {
            // empty catch block
        }
        upc = (Upc)UpcRepo.getJpa().merge(upc);
        if (upc == null) {
            throw new Exception("there was a problem persisting the item");
        }
        UpcRepo.getLog().info((Object)("new upc.getId(" + upc.getId() + ")"));
        return upc;
    }

    public static List<Upc> findByItem(Item item) {
        Query q = UpcRepo.getJpa().getEntityManager().createQuery("SELECT u FROM Upc u WHERE u.item = :item AND u.deleted = :deleted ORDER BY u.upcCode ASC");
        q.setParameter("item", (Object)item);
        q.setParameter("deleted", (Object)false);
        return q.getResultList();
    }

    public static List<Upc> findByItemAndInseam(Item item, int inseam) {
        Query q = UpcRepo.getJpa().getEntityManager().createQuery("SELECT u FROM Upc u JOIN u.size s WHERE u.item=:item AND s.inseam=:inseam AND u.deleted=:deleted ORDER BY u.upcCode ASC");
        q.setParameter("item", (Object)item);
        q.setParameter("inseam", (Object)inseam);
        q.setParameter("deleted", (Object)false);
        return q.getResultList();
    }
}

