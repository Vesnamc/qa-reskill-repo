package test.suites;

import calls.CrocodilesAPI;
import data.models.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Ana", "F", "2005-05-05");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);

    }

    @Test
    @Description("list of public crocodiles")
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();

        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    @Description("one public crocodile")
    public void getOnePublicCrocodile() {
        int r = getRandomNumber(1, 8);
        String id = Integer.toString(r);
        GetOnePublicCrocodileResponse getOnePublicCrocodileResponse = CrocodilesAPI.getOnePublicCrocodileResponse(id);
        crocodileAsserts.assertOnePublicCrocodile(getOnePublicCrocodileResponse);
    }

    @Test
    @Description("list of my private crocodiles")
    public void getListOfPrivateCrocodiles() {
        GetPrivateCrocodileResponse[] getPrivateCrocodileResponse = CrocodilesAPI.getPrivateCrocodileResponse(accessToken);
        crocodileAsserts.assertListOfPrivateCrocodiles(getPrivateCrocodileResponse);
    }

    @Test
    @Description("one of my crocodiles")
    public void getOneOfMyCrocodiles() {
        String firstId = getFirstID();

        GetOneOfMyCrocodilesResponse getOneOfMyCrocodilesResponse = CrocodilesAPI.getOneOfMyCrocodilesResponse(firstId, accessToken);
        crocodileAsserts.assertOneOfMyCrocodiles(getOneOfMyCrocodilesResponse);
    }

    @Test
    @Description("update one of my crocodiles")
    public void updateCrocodile() {
        String firstId = getFirstID();
        int id = Integer.parseInt(firstId);

        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest(id, "Ana", "F", "2007-05-05", 16);
        UpdateCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateNewCrocodileResponse(firstId, accessToken, updateCrocodileRequest);
        crocodileAsserts.assertUpdateMyCrocodile(updateCrocodileResponse, updateCrocodileRequest);
    }

    @Test
    @Description("patch one of my crocodiles")
    public void patchCrocodile() {
        String firstId = getFirstID();
        int id = Integer.parseInt(firstId);

        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest(id, "Annie",null,null,null);
        PatchCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchMyCrocodile(firstId, accessToken, patchCrocodileRequest);
        crocodileAsserts.assertPatchMyCrocodile(patchCrocodileResponse, patchCrocodileRequest);
    }

    @Test
    @Description("delete one of my crocodiles")
    public void deleteOneOfMyCrocodiles() {
        String firstId = getFirstID();

        DeleteCrocodileResponse deleteCrocodileResponse = CrocodilesAPI.deleteCrocodileResponse(firstId, accessToken);
        crocodileAsserts.assertDeletedCrocodile(deleteCrocodileResponse);
    }

}
