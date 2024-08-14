package org.atrinil.api.utils.asserwrapper;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.util.function.Predicate;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private SoftAssertions SOFT_ASSERTIONS;

    protected ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
        SOFT_ASSERTIONS = new SoftAssertions();
    }

    public static ResponseAssert assertThat(Response response) {
        return new ResponseAssert(response);
    }

    public ResponseAssert checkStatusCode(int expectedStatusCode) {
        SOFT_ASSERTIONS.assertThat(actual.getStatusCode())
                .isEqualTo(expectedStatusCode)
                .withFailMessage(String.format("Actual vs Expected Status = %s vs %s", actual.getStatusCode(), expectedStatusCode));
        return this;
    }

    public ResponseAssert checkContentType(String contentType) {
        SOFT_ASSERTIONS.assertThat(actual.contentType())
                .containsIgnoringCase(contentType)
                .withFailMessage(String.format("Actual vs Expected values = %s vs %s", actual.contentType(), contentType));
        return this;
    }

    public ResponseAssert canBeDeserializedTo(Class clazz) {
        SOFT_ASSERTIONS.assertThatCode(() -> actual.as(clazz))
                .doesNotThrowAnyException();
        return this;
    }

    public ResponseAssert checkKeyHasValue(String key, String expectedValue) {
        SOFT_ASSERTIONS.assertThat(actual.getBody().jsonPath().getString(key))
                .isEqualTo(expectedValue)
                .withFailMessage(String.format("Actual vs Expected Value for Key %s is %s vs %s", key,actual.getBody().jsonPath().getString(key), expectedValue));
        return this;
    }

    public ResponseAssert checkKeyHasValue(Predicate<Response> predicate) {
        SOFT_ASSERTIONS.assertThat(predicate)
                .accepts(actual);
        return this;
    }

    public void assertAll() {
        SOFT_ASSERTIONS.assertAll();
    }
}
