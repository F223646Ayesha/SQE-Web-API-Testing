package Test_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPut_Partner1 {
    @Test
    void TC3() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "Ayesha");
        requestBody.put("body", "What Do You Do?");
        requestBody.put("userId", 1);

        Response response = RestAssured.given()
                                       .contentType(ContentType.JSON)
                                       .body(requestBody)
                                       .put(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("title"), "Ayesha");
        Assert.assertEquals(response.jsonPath().getString("body"), "What Do You Do?");
    }
}