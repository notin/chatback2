package com.chatback;

import java.util.UUID;

public class GuiGenerator {
    public static String getGUIS() {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        return randomUUIDString;
    }
}