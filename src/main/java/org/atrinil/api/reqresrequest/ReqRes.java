package org.atrinil.api.reqresrequest;

import io.restassured.response.Response;
import org.atrinil.api.baserequestspec.BaseRequestSpec;
import org.atrinil.api.config.ApiConfigFactory;

public final class ReqRes {

    private ReqRes() {}

    private final static String GET_SINGLE_USER_ENDPOINT = ApiConfigFactory.getConfig().getSingleUserEndpoint();
    private final static String GET_USER_LIST_ENDPOINT = ApiConfigFactory.getConfig().getUserListEndpoint();

    public static Response getSingleUser() {
        return BaseRequestSpec.getBaseReqSpec()
                .pathParam("id", "2")
                .get(GET_SINGLE_USER_ENDPOINT)
                .then().extract()
                .response();
    }

    public static Response getSingleUser(int id) {
        return BaseRequestSpec.getBaseReqSpec()
                .pathParam("id", id)
                .get(GET_SINGLE_USER_ENDPOINT)
                .then().extract()
                .response();
    }

    public static Response getUserList() {
        return BaseRequestSpec.getBaseReqSpec()
                .get(GET_USER_LIST_ENDPOINT)
                .then().extract()
                .response();
    }
}
