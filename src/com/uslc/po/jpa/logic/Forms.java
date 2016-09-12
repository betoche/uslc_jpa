/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.logic;

public enum Forms {
    LOGIN(1),
    MASTER(2);
    
    private int id = 0;

    private Forms(String id, int n2, int n3) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static Forms getForm(int id) {
        Forms f = null;
        Forms[] arrforms = Forms.values();
        int n = arrforms.length;
        int n2 = 0;
        while (n2 < n) {
            Forms form = arrforms[n2];
            if (id == form.getId()) {
                f = form;
                break;
            }
            ++n2;
        }
        return f;
    }
}

