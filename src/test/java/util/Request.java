package util;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public interface Request {

    static Response get() {
        return RestAssured.get("https://reqres.in/api/users");
    }


}
