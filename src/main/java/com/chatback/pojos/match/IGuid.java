package com.chatback.pojos.match;

import java.util.UUID;

public interface IGuid {
    static String getGUIS()
    {
            // Creating a random UUID (Universally unique identifier).
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();

            return randomUUIDString;
    }
}
