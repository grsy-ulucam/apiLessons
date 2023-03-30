package homework;

import BaseURLs.BookerBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class day02 extends BookerBaseURL {

/*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/
@Test
public void task02() {

    specification.pathParam("bookingPath", "booking").queryParam("firstname", "Sarah");


    Response response = given().spec(specification).when().get("/{bookingPath}");

    response.prettyPrint();


    response.then().assertThat().statusCode(200);



    //    Kullanıcı GET Methodu ile Request Gönderir

    specification.pathParams("bookingPath","booking");

    specification.queryParam("firstname","Sarah");




    // Status Code un "200" olduğunu Assert et

    //response.then().assertThat().statusCode(200);



    response.then().assertThat().statusCode(200);



    JsonPath jsonPath=response.jsonPath();

    try {

        jsonPath.getInt("[0].bookingid");

        Assert.assertTrue(true);



    }catch (NullPointerException e) {


        Assert.fail("Boookingid bulunamadı");

    }



}



}
