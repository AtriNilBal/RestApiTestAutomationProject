package org.atrinil.api.tests.api.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atrinil.api.reqresservice.pojo.UserDetails;

import java.io.File;

import lombok.SneakyThrows;

public final class UserTestData {

    private UserTestData() {}

    @SneakyThrows
    public static UserDetails getUserDetails() {
        return new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir") + "/src/test/resources/payloadtemplates/create-user.json"), UserDetails.class)
                .setName("atri");
    }
}
