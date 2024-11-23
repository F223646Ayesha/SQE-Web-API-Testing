package Test_API_2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPost_Partner2 {
    @Test
    void TC2() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "New Post");
        requestBody.put("body", "This is a new post.");
        requestBody.put("userId", 1);

        Response response = RestAssured.given()
                                       .contentType(ContentType.JSON)
                                       .body(requestBody)
                                       .post(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("title"), "New Post");
        Assert.assertEquals(response.jsonPath().getString("body"), "This is a new post.");
    }
}
