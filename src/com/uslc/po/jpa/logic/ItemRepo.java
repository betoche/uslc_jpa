/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.Query
 */
package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.entity.Item;
import com.uslc.po.jpa.util.UslcJpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ItemRepo {
    private static UslcJpa jpa = null;

    public static List<Item> findAll() {
        Query q = ItemRepo.getJpa().getEntityManager().createQuery("SELECT i FROM Item i");
        return q.getResultList();
    }

    private static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static Item findByCode(String itemCode) {
        Item item = null;
        Query q = ItemRepo.getJpa().getEntityManager().createQuery("SELECT i FROM Item i WHERE i.code = :code");
        q.setParameter("code", (Object)itemCode);
        q.setMaxResults(1);
        List items = q.getResultList();
        if (items != null && items.size() > 0) {
            item = (Item)items.get(0);
        }
        return item;
    }

    public static Item createItem(Item item) throws Exception {
        item = (Item)ItemRepo.getJpa().merge(item);
        if (item == null) {
            throw new Exception("there was a problem persisting the item");
        }
        return item;
    }
}

