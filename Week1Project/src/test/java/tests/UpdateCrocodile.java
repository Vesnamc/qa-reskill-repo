package tests;

import common.RestAssuredFunctions;
import io.restassured.response.Response;
import static tests.MyCrocodileID.getFirstID;

public class UpdateCrocodile {

    public static void main(String[] args) {

        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");
        String id = getFirstID();

        String requestBody = "{\n" +
                "\"name\":\"Anna\", \n" +
                "\"sex\":\"F\", \n" +
                "\"date_of_birth\":\"2007-09-08\" \n" +
                "}";

        Response response = RestAssuredFunctions.put("my/crocodiles/"+id+"/", accessToken, requestBody);
        System.out.println(response.body().asString());
    }
}
