package test.common;

import calls.CrocodilesAPI;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.LoginRequest;
import environment.ConfigSetup;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = ConfigSetup.getBaseUrl();
        accessToken = CrocodilesAPI.login(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getDefaultPsw())).getAccess();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getFirstID() {

        Response response = RestAssuredFunctions.get(ApiEndpoints.MY_CROCODILES, accessToken);

        String responseAsString = response.body().asString();

        String firstId = responseAsString.substring(responseAsString.indexOf("id\":\"") +8, responseAsString.indexOf(",\"name"));

        return firstId;
    }
}
