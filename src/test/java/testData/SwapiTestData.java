package testData;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SwapiTestData {
   /*
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

    List<String> PilotList = new ArrayList<>();
    List<String> FilmList = new ArrayList<>(List.of("https://swapi.dev/api/films/1/"));


    public static HashMap<String,Object> expectedData;
    public HashMap setUpDataSwap() {

        expectedData = new HashMap<>();


        expectedData.put("name","X-34 landspeeder");
        expectedData.put("model","X-34 landspeeder");
        expectedData.put("manufacturer","SoroSuub Corporation");
        expectedData.put("cost_in_credits","10550");
        expectedData.put("length","3.4 ");
        expectedData.put("max_atmosphering_speed","250");
        expectedData.put("crew","1");
        expectedData.put("passengers","1");
        expectedData.put("cargo_capacity","5");
        expectedData.put("consumables","unknown");
        expectedData.put("vehicle_class","repulsorcraft");
        expectedData.put("pilots", PilotList );
        expectedData.put("films",FilmList);
        expectedData.put("created","2014-12-10T16:13:52.586000Z");
        expectedData.put("edited","2014-12-20T21:30:21.668000Z");
        expectedData.put("url","https://swapi.dev/api/vehicles/7/");

        return expectedData;


    }}