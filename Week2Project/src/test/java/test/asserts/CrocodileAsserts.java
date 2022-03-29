package test.asserts;

import data.models.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CommonCrocodileResponse response, CommonCrocodileRequest request) {
        softAssert.assertEquals(response.getName(), request.getName(), "Name didn't match");
        softAssert.assertEquals(response.getDateOfBirth(), request.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(response.getSex(), request.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for(int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertOnePublicCrocodile(GetOnePublicCrocodileResponse getOnePublicCrocodileResponse) {

        softAssert.assertFalse(getOnePublicCrocodileResponse.getName().isEmpty(), "Name is not empty");
        softAssert.assertFalse(getOnePublicCrocodileResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
        softAssert.assertFalse(getOnePublicCrocodileResponse.getSex().isEmpty(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPrivateCrocodiles(GetPrivateCrocodileResponse[] getPrivateCrocodileResponse) {
        for(int i = 0; i < getPrivateCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPrivateCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
            softAssert.assertFalse(getPrivateCrocodileResponse[i].getDateOfBirth().isEmpty(), "Date of birth didn't match");
            softAssert.assertFalse(getPrivateCrocodileResponse[i].getSex().isEmpty(), "Sex didn't match");
        }
        softAssert.assertAll();
    }

    public void assertOneOfMyCrocodiles(CommonCrocodileResponse getOneOfMyCrocodilesResponse) {

        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getName().isEmpty(), "Name is not empty");
        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getDateOfBirth().isEmpty(), "Date of birth didn't match");
        softAssert.assertFalse(getOneOfMyCrocodilesResponse.getSex().isEmpty(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateMyCrocodile(UpdateCrocodileResponse updateCrocodileResponse, UpdateCrocodileRequest updateCrocodileRequest) {
        softAssert.assertEquals(updateCrocodileResponse.getName(), updateCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), updateCrocodileRequest.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getSex(), updateCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertPatchMyCrocodile(PatchCrocodileResponse patchCrocodileResponse, PatchCrocodileRequest patchCrocodileRequest) {
        Assert.assertEquals(patchCrocodileResponse.getName(), patchCrocodileRequest.getName(), "Name didn't match");
    }

    public void assertDeletedCrocodile(DeleteCrocodileResponse deleteCrocodileResponse) {

        Assert.assertNull(deleteCrocodileResponse, "Delete crocodile contains data");
    }
}
