package org.atrinil.api.tests.api;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.atrinil.api.reqresservice.ReqRes;
import org.atrinil.api.reqresservice.pojo.UserDetails;
import org.atrinil.api.reqresservice.pojo.UserResponse;
import org.atrinil.api.tests.api.testdata.UserTestData;
import org.atrinil.api.utils.asserwrapper.ResponseAssert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.equalTo;

public class ReqResTests {

    @Test
    public void getCallTestAndValidateKeyInline() {//print response and inline validation of a response field
                ReqRes.getSingleUser().prettyPeek()
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void getCallTestAndValidateUsingCustomAssertion() {//print response and inline validation of a response field

        Response response = ReqRes.getSingleUser()
                .prettyPeek()
                .then()
                .extract().response();
        ResponseAssert.assertThat(response)
                .checkStatusCode(200)
                .checkContentType("application/json; charset=utf-8")
                .checkKeyHasValue("data.first_name", "Janet")
                .assertAll();

    }

    @Test
    public void getCallTestAndValidateUsingPredicate() {//print response and inline validation of a response field

        Predicate<Response> predicate = (res) -> res.jsonPath()
                .getString("data.email")
                .contentEquals("janet.weaver@reqres.in");

        Response response = ReqRes.getSingleUser()
                .prettyPeek()
                .then()
                .extract().response();
        ResponseAssert.assertThat(response)
                .checkStatusCode(200)
                .checkContentType("application/json; charset=utf-8")
                .checkKeyHasValue(predicate)
                .assertAll();

    }

    @Test
    public void getUserListAndValidate() {
        ReqRes.getUserList("2")
                .prettyPrint();
    }

    @Test
    public void createUser() {
        Predicate<Response> checkJobHasValueLeader = (response) -> response.jsonPath().getString("job")
                .equalsIgnoreCase("leader");
        UserDetails userDetails = null;
        userDetails = UserTestData.getUserDetails();
        System.out.println(userDetails);
        if(Objects.nonNull(userDetails)) {
            Response response = ReqRes.createUser(userDetails);
            ResponseAssert.assertThat(response)
                    .checkStatusCode(201)
                    .canBeDeserializedTo(UserResponse.class)
                    .checkKeyHasValue(checkJobHasValueLeader);
        }

    }

}
