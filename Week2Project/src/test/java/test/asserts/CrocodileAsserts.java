package test.asserts;

import calls.CrocodilesAPI;
import data.models.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CrocodileResponse response, CrocodileRequest request) {
        softAssert.assertEquals(response.getName(), request.getName(), "Name didn't match");
        softAssert.assertEquals(response.getDateOfBirth(), request.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(response.getSex(), request.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(CrocodileResponse[] getPublicCrocodileResponse) {
        for (CrocodileResponse crocodileResponse : getPublicCrocodileResponse) {
            softAssert.assertFalse(crocodileResponse.getName().isEmpty(), "Name is not empty");
            softAssert.assertFalse(crocodileResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
            softAssert.assertFalse(crocodileResponse.getSex().isEmpty(), "Sex didn't match");
        }
        softAssert.assertAll();
    }

    public void assertOnePublicCrocodile(CrocodileResponse getOnePublicCrocodileResponse) {
        softAssert.assertFalse(getOnePublicCrocodileResponse.getName().isEmpty(), "Name is not empty");
        softAssert.assertFalse(getOnePublicCrocodileResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
        softAssert.assertFalse(getOnePublicCrocodileResponse.getSex().isEmpty(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPrivateCrocodiles(CrocodileResponse[] getPrivateCrocodileResponse) {
        for (CrocodileResponse crocodileResponse : getPrivateCrocodileResponse) {
            softAssert.assertFalse(crocodileResponse.getName().isEmpty(), "Name is not empty");
            softAssert.assertFalse(crocodileResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
            softAssert.assertFalse(crocodileResponse.getSex().isEmpty(), "Sex didn't match");
        }
        softAssert.assertAll();
    }

    public void assertOneOfMyCrocodiles(CrocodileResponse getOneOfMyCrocodilesResponse) {
        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getName().isEmpty(), "Name is not empty");
        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getSex().isEmpty(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateMyCrocodile(CrocodileResponse updateCrocodileResponse, UpdateCrocodileRequest updateCrocodileRequest) {
        softAssert.assertEquals(updateCrocodileResponse.getName(), updateCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), updateCrocodileRequest.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getSex(), updateCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertPatchMyCrocodile(CrocodileResponse patchCrocodileResponse, PatchCrocodileRequest patchCrocodileRequest) {
        Assert.assertEquals(patchCrocodileResponse.getName(), patchCrocodileRequest.getName(), "Name didn't match");
    }

    public static boolean isUserExist(int id, String accessToken) {
        CrocodileResponse[] arrayOfUserResponse = CrocodilesAPI.getPrivateCrocodileResponse(accessToken);
        for (CrocodileResponse response : arrayOfUserResponse) {
            if (response.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
