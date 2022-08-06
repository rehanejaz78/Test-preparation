package Api;

import static io.restassured.RestAssured.* ;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GET {


    @Test
    public void GETAPI(){

        Response response = put("https://reqres.in/api/users/2");

        System.out.println(response.getBody().asString());
        System.out.println( response.getContentType());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());


        System.out.println("By using the given when then scenarios !!  ");

        given().get("https://reqres.in/api/users/2").then().body("data.first_name", equalTo  ("Janet"));


    }



}
