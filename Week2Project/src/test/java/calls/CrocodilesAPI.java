package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.*;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CommonCrocodileResponse createNewCrocodile(String accessToken, CommonCrocodileRequest commonCrocodileRequest) {
        Response post = RestAssuredFunctions.post(ApiEndpoints.MY_CROCODILES, accessToken, commonCrocodileRequest);
        return GsonFunctions.parseSuccessResponseToModel(post, CommonCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PUBLIC_CROCODILES), GetPublicCrocodileResponse[].class);
    }

    public static GetOnePublicCrocodileResponse getOnePublicCrocodileResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_PUBLIC_CROCODILE(id)), GetOnePublicCrocodileResponse.class);
    }

    public static GetPrivateCrocodileResponse[] getPrivateCrocodileResponse(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.MY_CROCODILES, accessToken), GetPrivateCrocodileResponse[].class);
    }

    public static CommonCrocodileResponse getOneOfMyCrocodilesResponse(String id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_CROCODILE(id), accessToken), CommonCrocodileResponse.class);
    }

    public static UpdateCrocodileResponse updateNewCrocodileResponse(String id, String accessToken, UpdateCrocodileRequest updateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.SINGLE_CROCODILE(id), accessToken, updateCrocodileRequest), UpdateCrocodileResponse.class);
    }

    public static PatchCrocodileResponse patchMyCrocodile(String id, String accessToken, PatchCrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.SINGLE_CROCODILE(id), accessToken, patchCrocodileRequest), PatchCrocodileResponse.class);
    }

    public static DeleteCrocodileResponse deleteCrocodileResponse(String id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.SINGLE_CROCODILE(id), accessToken), DeleteCrocodileResponse.class);
    }

}
