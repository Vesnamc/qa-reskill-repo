package common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {

    public static Response get(String url) {
        return given().contentType(ContentType.JSON).get(url);
    }

    public static Response get(String url, String accessToken) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).get(url);
    }

    public static Response post(String url, String requestBody) {
        return given().contentType(ContentType.JSON).body(requestBody).post(url).then().extract().response();
    }

    public static Response post(String url, String accessToken, String requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).post(url);
    }

    public static Response put(String url, String accessToken, String requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).put(url);
    }

    public static Response patch(String url, String accessToken, String requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).patch(url);
    }

    public static Response delete(String url, String accessToken) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).delete(url);
    }
}
