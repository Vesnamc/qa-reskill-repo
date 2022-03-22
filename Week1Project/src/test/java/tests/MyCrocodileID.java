package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyCrocodileID {

    public static String getFirstID() {

        RestAssured.baseURI = "https://test-api.k6.io/";

        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");

        Response response = RestAssuredFunctions.get("my/crocodiles/",accessToken);

        String responseAsString = response.body().asString();

        String id = responseAsString.substring(responseAsString.indexOf("id\":\"") +8, responseAsString.indexOf(",\"name"));

        return id;
    }
}
