package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMyCrocodiles {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://test-api.k6.io/";

        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");

        Response response = RestAssuredFunctions.get("my/crocodiles/",accessToken);

        System.out.println(response.body().asString());
    }
}
