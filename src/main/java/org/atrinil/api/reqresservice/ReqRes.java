package org.atrinil.api.reqresservice;

import io.restassured.response.Response;
import org.atrinil.api.reqresservice.baserequestspec.BaseRequestSpec;
import org.atrinil.api.config.ApiConfigFactory;
import org.atrinil.api.reqresservice.pojo.UserDetails;

public final class ReqRes {

    private ReqRes() {}

    private final static String SINGLE_USER_ENDPOINT = ApiConfigFactory.getConfig().getSingleUserEndpoint();
    private final static String LIST_USERS_ENDPOINT = ApiConfigFactory.getConfig().getUserListEndpoint();
    private final static String CREATE_USER_ENDPOINT = ApiConfigFactory.getConfig().createUserEndpoint();

    public static Response getSingleUser() {
        return BaseRequestSpec.getBaseReqSpec()
                .pathParam("id", "2")
                .get(SINGLE_USER_ENDPOINT);
    }

    public static Response getSingleUser(int id) {
        return BaseRequestSpec.getBaseReqSpec()
                .pathParam("id", id)
                .get(SINGLE_USER_ENDPOINT);
    }

    public static Response getUserList() {
        return BaseRequestSpec.getBaseReqSpec()
                .queryParam("page", "2")
                .get(LIST_USERS_ENDPOINT);
    }

    public static Response getUserList(String pageNo) {
        return BaseRequestSpec.getBaseReqSpec()
                .queryParam("page", pageNo)
                .get(LIST_USERS_ENDPOINT);
    }

    public static Response createUser(UserDetails userDetails) {
        return BaseRequestSpec.getBaseReqSpec()
                .when()
                .body(userDetails)
                .post(CREATE_USER_ENDPOINT);
    }
}
