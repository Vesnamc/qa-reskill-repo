package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.*;
import data.models.authentication.LoginRequest;
import data.models.authentication.LoginResponse;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CrocodileResponse createNewCrocodile(String accessToken, CrocodileRequest commonCrocodileRequest) {
        Response post = RestAssuredFunctions.post(ApiEndpoints.MY_CROCODILES, accessToken, commonCrocodileRequest);
        return GsonFunctions.parseSuccessResponseToModel(post, CrocodileResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PUBLIC_CROCODILES), CrocodileResponse[].class);
    }

    public static CrocodileResponse getOnePublicCrocodileResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_PUBLIC_CROCODILE(id)), CrocodileResponse.class);
    }

    public static CrocodileResponse[] getPrivateCrocodileResponse(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.MY_CROCODILES, accessToken), CrocodileResponse[].class);
    }

    public static CrocodileResponse getOneOfMyCrocodilesResponse(String id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_CROCODILE(id), accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse updateNewCrocodileResponse(String id, String accessToken, UpdateCrocodileRequest updateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.SINGLE_CROCODILE(id), accessToken, updateCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchMyCrocodile(String id, String accessToken, PatchCrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.SINGLE_CROCODILE(id), accessToken, patchCrocodileRequest), CrocodileResponse.class);
    }

    public static void deleteCrocodileResponse(String id, String accessToken) {
        GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.SINGLE_CROCODILE(id), accessToken), DeleteCrocodileResponse.class);
    }

}
