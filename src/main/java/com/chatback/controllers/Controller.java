package com.chatback.controllers;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Controller {

    public static final String IP = getLocalIP();

    private static final String getLocalIP()
    {
        String localip = null;

        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            localip = socket.getLocalAddress().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localip;
    }
}
