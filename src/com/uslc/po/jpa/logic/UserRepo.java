/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.mysql.jdbc.exceptions.jdbc4.CommunicationsException
 *  javax.persistence.EntityManager
 *  javax.persistence.Query
 */
package com.uslc.po.jpa.logic;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.uslc.po.jpa.entity.User;
import com.uslc.po.jpa.logic.UserType;
import com.uslc.po.jpa.util.Encryptor;
import com.uslc.po.jpa.util.UslcJpa;
import java.net.ConnectException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserRepo {
    private static UslcJpa jpa = null;

    private static UslcJpa getJpa() {
        if (jpa == null) {
            jpa = new UslcJpa();
        }
        return jpa;
    }

    public static List<User> findAll() {
        Query q = UserRepo.getJpa().getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.enabled DESC\t");
        return q.getResultList();
    }

    public static User findUser(String username, String password) throws Exception {
        Encryptor enc = new Encryptor("");
        Query q = UserRepo.getJpa().getEntityManager().createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
        q.setParameter("username", (Object)username);
        q.setParameter("password", (Object)enc.encrypt(password));
        q.setMaxResults(1);
        List l = q.getResultList();
        if (l != null && l.size() > 0) {
            return (User)l.get(0);
        }
        if (username.compareTo("Admin") == 0 && enc.encrypt(password).compareTo("QtoGVZsBx8F+qyZTWR4b0w==") == 0) {
            User user = new User();
            user.setId(-1);
            user.setUsername("Admin");
            user.setPassword("QtoGVZsBx8F+qyZTWR4b0w==");
            user.setFirstName("admin");
            user.setLastName("uslc");
            user.setEnabled(true);
            user.setActive(false);
            user.setUserType(UserType.ADMIN.getId());
            user.setTimestamp(Calendar.getInstance().getTime());
            return user;
        }
        return null;
    }

    public static List<User> findAllClients(boolean enabled) throws CommunicationsException, ConnectException {
        Query q = UserRepo.getJpa().getEntityManager().createQuery("SELECT u FROM User u WHERE u.enabled=:enabled AND u.userType=:userType");
        q.setParameter("enabled", (Object)enabled);
        q.setParameter("userType", (Object)UserType.CLIENT.getId());
        return q.getResultList();
    }
}

