package org.atrinil.api.tests.api.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atrinil.api.reqresservice.pojo.UserDetails;

import java.io.File;
import java.io.IOException;

public final class UserTestData {

    private UserTestData() {}

    public static UserDetails getUserDetails() throws IOException {
        return new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/payloadtemplates/create-user.json"), UserDetails.class)
                .setName("atri");
    }
}
