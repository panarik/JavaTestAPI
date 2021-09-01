package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExample {

    @Test
    public void test1() {
        System.out.println("testing...");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() throws InterruptedException {
//        Response response = RestAssured.get("https://analyticsreporting.googleapis.com/v4/reports:batchGet?key=[YOUR_API_KEY]");
//        Response response1 = RestAssured.post("https://analyticsreporting.googleapis.com/v4/reports:batchGet?key=[YOUR_API_KEY]");
        Response response2 = RestAssured.get("https://api.nasa.gov/planetary/apod?api_key=uDW6ziYUtm9UbNrafP0mveSgLb8wdsRYXsiBQgSI");
        System.out.println("response timing: "+response2.getTime());
        System.out.println(response2.getStatusLine());
        System.out.println(response2.getHeaders());
        System.out.println(response2.getHeader("Content-Type"));
        System.out.println(response2.getBody().asString());
        Assert.assertNotNull(response2);
    }

    @Test
    public void test3() {
        get("https://api.nasa.gov/planetary/apod?api_key=uDW6ziYUtm9UbNrafP0mveSgLb8wdsRYXsiBQgSI")
                .then()
                .statusCode(200)
                .body("date", equalTo("2021-09-01"));
    }

}
