package tests;

import common.RestAssuredFunctions;
import io.restassured.response.Response;
import static tests.MyCrocodileID.getFirstID;

public class UpdateField {

    public static void main(String[] args) {

        String accessToken = GetTokenResponse.login("vesnaM", "pass1234");
        String id = getFirstID();

        String requestBody = "{\n" +
                "\"name\":\"Annie\" \n}";

        Response response = RestAssuredFunctions.patch("my/crocodiles/"+id+"/", accessToken, requestBody);
        System.out.println(response.body().asString());
    }
}
