/*
 * Decompiled with CFR 0_115.
 */
package com.uslc.po.jpa.test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;

public class NetworkPing {
    public static void main(String[] args) throws IOException {
        InetAddress localhost = InetAddress.getLocalHost();
        byte[] ip = localhost.getAddress();
        int i = 1;
        while (i <= 254) {
            ip[3] = (byte)i;
            InetAddress address = InetAddress.getByAddress(ip);
            if (address.isReachable(1000)) {
                System.out.println(address + " machine is turned on and can be pinged");
            } else if (!address.getHostAddress().equals(address.getHostName())) {
                System.out.println(address + " machine is known in a DNS lookup");
            } else {
                System.out.println(address + " the host address and host name are equal, meaning the host name could not be resolved");
            }
            ++i;
        }
    }
}

