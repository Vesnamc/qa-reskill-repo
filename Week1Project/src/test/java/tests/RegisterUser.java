package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegisterUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://test-api.k6.io/";

        String requestBody = "{\n" +
                "\"username\":\"vesnaM\", \n" +
                "\"first_name\":\"Vesna\", \n" +
                "\"last_name\":\"Mc\", \n" +
                "\"email\":\"vesna@gmail.com\", \n" +
                "\"password\":\"pass1234\" \n" +
                "}";

        Response response = RestAssuredFunctions.post("/user/register/", requestBody);

        String responseAsString = response.body().asString();
        System.out.println(responseAsString);
    }

}
