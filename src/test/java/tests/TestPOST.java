package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.testng.annotations.Test;
import util.JSONParser;
import util.jsonObjects.user.User;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPOST {

    @Test
    public void test1() {
        User user = new User();
        user.setName("One");
        user.setProfession("Tester");

        String json = JSONParser.parse(user);

        ValidatableResponseOptions<ValidatableResponse, Response> response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(json)
                .post("https://reqres.in/api/users")
                .then();

        System.out.println(response.log().all());
        response.statusCode(201);


    }

}
