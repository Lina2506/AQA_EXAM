package org.base.helpers;

import java.util.UUID;

public class TestDataForAPITests {
    public static String generateUsername() {
        return "Test"+ UUID.randomUUID().toString().replace("-", "").substring(0,10);
    }
    public static final String DEFAULT_PASSWORD = "Aqa12345!";
}
