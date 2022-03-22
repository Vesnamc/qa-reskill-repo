package test.common;

import calls.CrocodilesAPI;
import common.RestAssuredFunctions;
import data.models.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://test-api.k6.io";
        accessToken = CrocodilesAPI.login(new LoginRequest("vesnaM", "pass1234")).getAccess();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getFirstID() {

        Response response = RestAssuredFunctions.get("my/crocodiles/", accessToken);

        String responseAsString = response.body().asString();

        String firstId = responseAsString.substring(responseAsString.indexOf("id\":\"") +8, responseAsString.indexOf(",\"name"));

        return firstId;
    }
}
