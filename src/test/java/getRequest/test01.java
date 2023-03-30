package getRequest;

import BaseURLs.SwapiApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.SwapiPojoss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class test01 extends SwapiApiBaseURL {
    /*
      /*

        Given

            https://swapi.dev/api/starships/3

       When

            Kullanıcı GET Methodu ile Request Gönderir

        Then

             Status Code un "200" olduğunu Assert et

        And

            Response body nin bu şekilde olduğunu doğrular

         {

    "name": "Star Destroyer",

    "model": "Imperial I-class Star Destroyer",

    "manufacturer": "Kuat Drive Yards",

    "cost_in_credits": "150000000",

    "length": "1,600",

    "max_atmosphering_speed": "975",

    "crew": "47,060",

    "passengers": "n/a",

    "cargo_capacity": "36000000",

    "consumables": "2 years",

    "hyperdrive_rating": "2.0",

    "MGLT": "60",

    "starship_class": "Star Destroyer",

    "pilots": [],

    "films": [

        "https://swapi.dev/api/films/1/",

        "https://swapi.dev/api/films/2/",

        "https://swapi.dev/api/films/3/"

    ],

    "created": "2014-12-10T15:08:19.848000Z",

    "edited": "2014-12-20T21:23:49.870000Z",

    "url": "https://swapi.dev/api/starships/3/"

}

     */

    @Test
    public void test01(){

        //Step 1: Set URL
        //https://swapi.dev/api/starships/3
        specification.pathParams("starPath", "starships",
                "idPath", "3");



        //Step 2: Set Expected Data

        ArrayList<String> films = new ArrayList<>(List.of("https://swapi.dev/api/films/1/","https://swapi.dev/api/films/2/","https://swapi.dev/api/films/3/"));
        ArrayList <String> pilots = new ArrayList<>();

        SwapiPojoss swapiPojoss = new SwapiPojoss("Star Destroyer",
                "Imperial I-class Star Destroyer",
                "Kuat Drive Yards",
                "150000000",
                "1,600",
                "975",
                "47,060",
                "n/a",
                "36000000",
                "2 years",
                "2.0",
                "60",
                "Star Destroyer",
                pilots,
                films,
                "2014-12-10T15:08:19.848000Z",
                "2014-12-20T21:23:49.870000Z",
                "https://swapi.dev/api/starships/3/");


        //Step 3: Send a Request
        Response response = given().spec(specification).when().get("/{starPath}/{idPath}");

        response.prettyPrint();

        //Step 4: Assertion

        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualDataMap);

        assertEquals(swapiPojoss.getName(),actualDataMap.get("name"));
        assertEquals(swapiPojoss.getModel(),actualDataMap.get("model"));
        assertEquals(swapiPojoss.getManufacturer(),actualDataMap.get("manufacturer"));
        assertEquals(swapiPojoss.getCost_in_credits(),actualDataMap.get("cost_in_credits"));
        assertEquals(swapiPojoss.getLength(),actualDataMap.get("length"));
        assertEquals(swapiPojoss.getMax_atmosphering_speed(),actualDataMap.get("max_atmosphering_speed"));
        assertEquals(swapiPojoss.getCrew(),actualDataMap.get("crew"));
        assertEquals(swapiPojoss.getPassengers(),actualDataMap.get("passengers"));
        assertEquals(swapiPojoss.getCargo_capacity(),actualDataMap.get("cargo_capacity"));
        assertEquals(swapiPojoss.getConsumables(),actualDataMap.get("consumables"));
        assertEquals(swapiPojoss.getHyperdrive_rating(),actualDataMap.get("hyperdrive_rating"));
        assertEquals(swapiPojoss.getMGLT(),actualDataMap.get("MGLT"));
        assertEquals(swapiPojoss.getStarship_class(),actualDataMap.get("starship_class"));
        assertEquals(swapiPojoss.getPilots(),actualDataMap.get("pilots"));
        assertEquals(swapiPojoss.getFilms(),actualDataMap.get("films"));
        assertEquals(swapiPojoss.getCreated(),actualDataMap.get("created"));
        assertEquals(swapiPojoss.getEdited(),actualDataMap.get("edited"));
        assertEquals(swapiPojoss.getUrl(),actualDataMap.get("url"));

    }

}
