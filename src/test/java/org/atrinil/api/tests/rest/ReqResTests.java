package org.atrinil.api.tests.rest;

import org.atrinil.api.config.ApiConfigFactory;
import org.testng.annotations.Test;

public class ReqResTests {

    private final String BASE_URL = ApiConfigFactory.getConfig().baseUrl();

    @Test
    public void getSingleUserTest() {
        System.out.println(BASE_URL);
    }
}
