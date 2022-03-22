package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), GetPublicCrocodileResponse[].class);
    }

    public static GetOnePublicCrocodileResponse getOnePublicCrocodileResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"+id+"/"), GetOnePublicCrocodileResponse.class);
    }

    public static GetPrivateCrocodileResponse[] getPrivateCrocodileResponse(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), GetPrivateCrocodileResponse[].class);
    }

    public static GetOneOfMyCrocodilesResponse getOneOfMyCrocodilesResponse(String id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/"+id+"/", accessToken), GetOneOfMyCrocodilesResponse.class);
    }

    public static UpdateCrocodileResponse updateNewCrocodileResponse(String id, String accessToken, UpdateCrocodileRequest updateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/"+id+"/", accessToken, updateCrocodileRequest), UpdateCrocodileResponse.class);
    }

    public static PatchCrocodileResponse patchMyCrocodile(String id, String accessToken, PatchCrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/"+id+"/", accessToken, patchCrocodileRequest), PatchCrocodileResponse.class);
    }

    public static DeleteCrocodileResponse deleteCrocodileResponse(String id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/"+id+"/", accessToken), DeleteCrocodileResponse.class);
    }

}
