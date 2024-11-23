package Test_API_2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPut_Partner2 {
    @Test
    void TC3() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "Updated Title");
        requestBody.put("body", "Updated content of the post.");
        requestBody.put("userId", 1);

        Response response = RestAssured.given()
                                       .contentType(ContentType.JSON)
                                       .body(requestBody)
                                       .put(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("title"), "Updated Title");
        Assert.assertEquals(response.jsonPath().getString("body"), "Updated content of the post.");
    }
}
