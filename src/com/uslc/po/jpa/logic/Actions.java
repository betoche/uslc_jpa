/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.logic;

import com.uslc.po.jpa.logic.Forms;

public enum Actions {
    LOGIN(1, Forms.LOGIN, "Just loging."),
    EXIT(2, Forms.MASTER, "just exiting the application");
    
    private int id = 0;
    private Forms form = null;
    private String action = "";

    private Actions(String id, int form, int action, Forms forms, String string2) {
        this.id = id;
        this.form = (Forms)form;
        this.action = (String)action;
    }

    public int getId() {
        return this.id;
    }

    public Forms getForm() {
        return this.form;
    }

    public String getAction() {
        return this.action;
    }

    public static Actions getAction(int id) {
        Actions a = null;
        Actions[] arractions = Actions.values();
        int n = arractions.length;
        int n2 = 0;
        while (n2 < n) {
            Actions action = arractions[n2];
            if (id == action.getId()) {
                a = action;
                break;
            }
            ++n2;
        }
        return a;
    }
}

