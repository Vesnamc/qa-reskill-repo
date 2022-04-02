package test.suites;

import calls.CrocodilesAPI;
import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.*;
import data.provider.CrocodileProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

import static data.provider.CrocodileProvider.DF;

public class CrocodileTests extends TestBase {

    private CrocodileRequest commonCrocodileRequest;
    private int idOfCreatedCrocodile;

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @BeforeMethod
    public void prepareTestData(){
        commonCrocodileRequest = CrocodileProvider.prepareCrocodile();
        idOfCreatedCrocodile = getOrCreateCrocodile().getId();
    }

    private CrocodileResponse getOrCreateCrocodile() {
        CrocodileResponse[] arrayOfUserResponse = CrocodilesAPI.getPrivateCrocodileResponse(accessToken);
        if (arrayOfUserResponse.length > 0){
            int index = getRandomNumber(0, arrayOfUserResponse.length);
            //System.out.println("exiting index " + index + " of " + arrayOfUserResponse.length);
            return arrayOfUserResponse[index];
        }
        //System.out.println("new created");

        return CrocodilesAPI.createNewCrocodile(accessToken, commonCrocodileRequest);
    }

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CrocodileResponse commonCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, commonCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(commonCrocodileResponse, commonCrocodileRequest);

    }

    @Test
    @Description("list of public crocodiles")
    public void getListOfPublicCrocodiles() {
        CrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    @Description("one public crocodile")
    public void getOnePublicCrocodile() {
        int r = getRandomNumber(1, 8);
        String id = Integer.toString(r);
        CrocodileResponse getOnePublicCrocodileResponse = CrocodilesAPI.getOnePublicCrocodileResponse(id);
        crocodileAsserts.assertOnePublicCrocodile(getOnePublicCrocodileResponse);
    }

    @Test
    @Description("list of my private crocodiles")
    public void getListOfPrivateCrocodiles() {
        CrocodileResponse[] getPrivateCrocodileResponse = CrocodilesAPI.getPrivateCrocodileResponse(accessToken);
        crocodileAsserts.assertListOfPrivateCrocodiles(getPrivateCrocodileResponse);
    }

    @Test
    @Description("one of my crocodiles")
    public void getOneOfMyCrocodiles() {
        CrocodileResponse getOneOfMyCrocodilesResponse = CrocodilesAPI.getOneOfMyCrocodilesResponse(String.valueOf(idOfCreatedCrocodile), accessToken);
        crocodileAsserts.assertOneOfMyCrocodiles(getOneOfMyCrocodilesResponse);
    }

    @Test
    @Description("update one of my crocodiles")
    public void updateCrocodile() {
        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest(idOfCreatedCrocodile, Faker.instance().gameOfThrones().character(), ValueChoosers.getRandomSex(), DF.format(Faker.instance().date().birthday()), 16);
        CrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateNewCrocodileResponse(String.valueOf(idOfCreatedCrocodile), accessToken, updateCrocodileRequest);
        crocodileAsserts.assertUpdateMyCrocodile(updateCrocodileResponse, updateCrocodileRequest);
    }

    @Test
    @Description("patch one of my crocodiles")
    public void patchCrocodile() {
        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest(idOfCreatedCrocodile, Faker.instance().gameOfThrones().character(),null,null,null);
        CrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchMyCrocodile(String.valueOf(idOfCreatedCrocodile), accessToken, patchCrocodileRequest);
        crocodileAsserts.assertPatchMyCrocodile(patchCrocodileResponse, patchCrocodileRequest);
    }

    @Test
    @Description("delete one of my crocodiles")
    public void deleteOneOfMyCrocodiles() {
        CrocodilesAPI.deleteCrocodileResponse(String.valueOf(idOfCreatedCrocodile), accessToken);
        Assert.assertFalse(CrocodileAsserts.isUserExist(idOfCreatedCrocodile, accessToken), "User is not deleted");
    }

}
