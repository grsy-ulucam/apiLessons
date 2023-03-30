package homework;

import BaseURLs.GoRestCoBaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.Gorestpojooo;
import utilities.JsonToJava;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homewroksss5 extends GoRestCoBaseURL {

        
        /*
    
        Given
            https://gorest.co.in/public/v2/users
        And
    
               Request Body olarak aşağıdaki pattern de body gönderiniz
               {
      "name": "Tenali Ramakrishna",
      "gender": "male",
      "email": "tenali.ramakrishna@15ce.com",
      "status": "active"
    }
        When
            Kullanıcı POST Methodu ile Request Gönderir
        Then
            Status Code un "201" olduğunu Assert et
        And
               Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
                 {
      "name": "Tenali Ramakrishna",
      "gender": "male",
      "email": "tenali.ramakrishna@15ce.com",
      "status": "active"
    }
    
       */
        
    @Test
    public void homework5(){

        //Set Base URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath","users");

        String expectedData = "{\n" +
                "        \"name\": \"Adhiraj Mehra\",\n" +
                "        \"email\": \"mehra_adhiraj@kutch-gulgowski.info\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"inactive\"\n" +
                "    }";
        

        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");

        Gorestpojooo gorestpojooooo = JsonToJava.convertJsonToJavaObject (expectedData, Gorestpojooo.class);

        System.out.println("gorestpojooooooo: " + gorestpojooooo);

        //

        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        System.out.println("expectedDataMap: " + expectedDataMap );

        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(expectedDataMap).
                when().
                header("Authorization","Bearer 3197bbebe2105fec462ba0e75070318fcc7592cc707794557255c6b945358683").
                post("/{usersPath}");

        response.prettyPrint();

        // Assertion

        HashMap<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedDataMap.get("name"),actualData.get("name"));
        assertEquals(expectedDataMap.get("gender"),actualData.get("gender"));
        assertEquals(expectedDataMap.get("email"),actualData.get("email"));
        assertEquals(expectedDataMap.get("status"),actualData.get("status"));


    }}