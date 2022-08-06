package Api;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Post {

    @Test
    public void post(){

        //post api test

        JSONObject reponse = new JSONObject();

        reponse.put("email", "eve.holt@reqres.in");
        reponse.put("password","pistol");


        int code2 = given().queryParam("token","QpwL5tke4Pnpja7X4") .auth() .preemptive().basic("eve.holt@reqres.in","pistol").when().post("https://reqres.in/api/register").getStatusCode();

        System.out.println(code2);

      int code = given().body(reponse.toJSONString()).when().post("https://reqres.in/api/register").getStatusCode();  // .then().log().status().statusCode(201);


        System.out.println(code);


        //post request

        String res =  given().body(reponse.toJSONString()).when().post("https://reqres.in/api/register").getBody().asString();

        System.out.println(res);



    }


    }

