package homework;

import BaseURLs.SwapiApiBaseURL;

import io.restassured.response.Response;
import org.junit.Test;
import testData.SwapiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class day04 extends SwapiApiBaseURL {

    /*
    Given
             https://swapi.dev/api/vehicles/7
        When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
             Response body nin bu şekilde olduğunu doğrular
{
    "name": "X-34 landspeeder",
    "model": "X-34 landspeeder",
    "manufacturer": "SoroSuub Corporation",
    "cost_in_credits": "10550",
    "length": "3.4 ",
    "max_atmosphering_speed": "250",
    "crew": "1",
    "passengers": "1",
    "cargo_capacity": "5",
    "consumables": "unknown",
    "vehicle_class": "repulsorcraft",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/"
    ],
    "created": "2014-12-10T16:13:52.586000Z",
    "edited": "2014-12-20T21:30:21.668000Z",
    "url": "https://swapi.dev/api/vehicles/7/"
}
     */


    @Test
    public void test01(){

        //STEP 1 : SET URL
        specification.pathParams("vehiclePath","vehicles","idpath","7");




        //Step 2 Expected Data
        SwapiTestData swapiTestData = new SwapiTestData();
        HashMap<String,Object> expectedData = swapiTestData.setUpDataSwap();

        System.out.println("expectedData = " + expectedData);


        //Step 3 Request Data
        Response response = given().when().spec(specification).get("/{vehiclePath}/{idpath}");

        response.prettyPrint();

        //Step 4 Response

        response.then().statusCode(200);

        HashMap<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData,actualData);




    }}