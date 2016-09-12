/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.logic;

public enum UserType {
    ADMIN(0),
    CLIENT(1);
    
    private int id = -1;

    private UserType(String id, int n2, int n3) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

