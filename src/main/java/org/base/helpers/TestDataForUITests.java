package org.base.helpers;

import java.util.UUID;

public class TestDataForUITests {
    public static String generateUserName() {
        return "PolinaTest-"+ UUID.randomUUID();
    }
    public static final String DEFAULT_PASSWORD = "Polina_test";
}
