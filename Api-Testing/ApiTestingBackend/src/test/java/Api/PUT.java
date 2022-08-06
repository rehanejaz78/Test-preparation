package Api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class PUT {


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

}
