package tests;

import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class TestBase {

    public TestBase() {
        ValidatableResponseOptions<ValidatableResponse, Response> response;
    }
}
