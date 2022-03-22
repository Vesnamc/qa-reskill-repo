package tests;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Scanner;

public class GetSingleCrocodile {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://test-api.k6.io/";

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number between 1 and 8: ");
        String id= sc.nextLine();

        Response response = RestAssuredFunctions.get("public/crocodiles/"+id+"/");

        System.out.println(response.body().asString());
    }
}
