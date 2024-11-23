package Test_API_2;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet_Partner2 {
    @Test
    void TC1() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        Response response = RestAssured.given()
                                       .get(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
    }
}
