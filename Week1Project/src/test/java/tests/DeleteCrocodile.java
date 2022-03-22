package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static tests.MyCrocodileID.getFirstID;

public class DeleteCrocodile {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://test-api.k6.io/";
        String id = getFirstID();

        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");

        Response response = RestAssuredFunctions.delete("my/crocodiles/"+id+"/",accessToken);

    }
}
