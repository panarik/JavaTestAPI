package tests;

import io.restassured.RestAssured;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Request;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGET extends TestBase {

    @Test
    public void test1() {
        ValidatableResponseOptions<ValidatableResponse, Response> response = given()
                .header("Content-Type", "application/json")
                .param("page", 2)
                .get("https://reqres.in/api/users")
                .then();
        System.out.println(response.log().all());
        response.statusCode(200);
        response.body(containsString("total_pages"));
        response.body("data.id[0]", equalTo(7)); //проверка: соответствует ли значение по ключу в списке
        response.body("data.id", hasItem(8)); //проверка: есть ли в списке значение
        response.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias")); //проверка: есть ли в списке данные значения
    }

    @Test
    public void test2() {
        Response response = Request.get();
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
