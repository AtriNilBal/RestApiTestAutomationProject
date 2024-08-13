package org.atrinil.api.baserequestspec;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.atrinil.api.config.ApiConfigFactory;

public final class BaseRequestSpec {
    private BaseRequestSpec() {}

    private static final String BASE_URL = ApiConfigFactory.getConfig().baseUrl();

    public static RequestSpecification getBaseReqSpec() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .log()
                .all();
    }
}
