package org.atrinil.api.tests.rest;

import io.restassured.RestAssured;
import org.atrinil.api.baserequestspec.BaseRequestSpec;
import org.atrinil.api.config.ApiConfigFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class ReqResTests {

    private final String GET_SINGLE_USER_ENDPOINT = ApiConfigFactory.getConfig().getSingleUserEndpoint();

    @Test
    public void getSingleUserTest() {
        BaseRequestSpec.getBaseReqSpec()
                .when()
                .get(GET_SINGLE_USER_ENDPOINT)
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));
    }

}
