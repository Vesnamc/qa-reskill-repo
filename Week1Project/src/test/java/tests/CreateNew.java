package tests;

import io.restassured.response.Response;
import common.RestAssuredFunctions;

public class CreateNew {

    public static void main(String[] args) {
        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");

        String requestBody = "{\n" +
                "\"name\":\"Gille\", \n" +
                "\"sex\":\"M\", \n" +
                "\"date_of_birth\":\"2010-01-01\" \n" +
                "}";

        Response response = RestAssuredFunctions.post("my/crocodiles/" , accessToken, requestBody);
        System.out.println(response.body().asString());
    }

}
