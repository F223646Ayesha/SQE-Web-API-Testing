package Test_API;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestDelete_Partner1 {
    @Test
    void TC4() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Response response = RestAssured.given()
                                       .delete(url);

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(200, response.getStatusCode());

        Response getResponse = RestAssured.given()
                                          .get(url);
        Assert.assertEquals(200, getResponse.getStatusCode());
    }
}
