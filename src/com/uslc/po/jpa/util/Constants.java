/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.util;

public enum Constants {
    MESSAGE_BOX_DIAG_TITLE("USLC Apparel - PO Master");
    
    private String msg = "";

    private Constants(String msg, int n2, String string2) {
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }
}

