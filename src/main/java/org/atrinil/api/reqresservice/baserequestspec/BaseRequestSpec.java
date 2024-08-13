package org.atrinil.api.reqresservice.baserequestspec;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.atrinil.api.config.ApiConfigFactory;

public final class BaseRequestSpec {
    private BaseRequestSpec() {}

    private static final String BASE_URL = ApiConfigFactory.getConfig().baseUrl();

    public static RequestSpecification getDefaultRequestSpec() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .log()
                .all();
    }
}
