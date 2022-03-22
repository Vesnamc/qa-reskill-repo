package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTokenResponse {

    public static String login(String userName, String pass) {

        RestAssured.baseURI = "https://test-api.k6.io/";

        String requestBody = "{\n" +
                "\"username\":\"vesnaM\", \n" +
                "\"password\":\"pass1234\" \n" +
                "}";

        Response response = RestAssuredFunctions.post("auth/token/login/", requestBody);

        String responseAsString = response.body().asString();
        String accessToken = responseAsString.substring(responseAsString.indexOf("access\":\"") +9, responseAsString.indexOf("\"}"));
        return accessToken;

    }
}
