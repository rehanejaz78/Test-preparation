package Api;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class PUTDel {


    @Test
    public void Put() {

        RestAssured.baseURI="https://qa-hcc.mynisum.com/api/v1/auth";

        given().log().all()
                .relaxedHTTPSValidation()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"username\": \"reejaz@nisum.com\",\n" +
                        "    \"password\": \"442935\"\n" +
                        "}").when().post("/login").then().log().all().extract().response();

    }

    @Test
    public void hccDesignationGet(){

        //https://qa-hcc.mynisum.com/api/v1/general/designations

        RestAssured.baseURI="https://qa-hcc.mynisum.com/api/v1/general";
        given().log().all().relaxedHTTPSValidation().when().get("/designations").then().statusCode(200).
                log().all()
                .extract().response();

    }


    @Test
    public void Delete(){


        given().when().delete("https://reqres.in/api/users/2").then().statusCode(204);
    }

}
