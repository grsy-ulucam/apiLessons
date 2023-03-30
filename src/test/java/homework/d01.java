package homework;

public class d01 {


    /*


@Test

    public void task02() {



        specification.pathParam("bookingPath","booking").queryParam("firstname","Sarah");



        Response response = given().spec(specification).when().get("/{bookingPath}");

        response.prettyPrint();



        response.then().assertThat().statusCode(200);


        JsonPath jsonPath = response.jsonPath();



        try {

            jsonPath.getInt("[0].bookingid");

            Assert.assertTrue(true);



        }catch (NullPointerException e){



            Assert.fail("Bookingid bulunamadı");



        }



    }



*********************



@Test

    public void task03(){

        specification.pathParams("employeePath","employee","idPath","1");



        Response response = given().spec(specification).when().get("/{employeePath}/{idPath}");

        response.prettyPrint();





       String expectedData = "{\n" +

               "    \"status\": \"success\",\n" +

               "    \"data\": {\n" +

               "        \"id\": 1,\n" +

               "        \"employee_name\": \"Tiger Nixon\",\n" +

               "        \"employee_salary\": 320800,\n" +

               "        \"employee_age\": 61,\n" +

               "        \"profile_image\": \"\"\n" +

               "    },\n" +

               "    \"message\": \"Successfully! Record has been fetched.\"\n" +

               "}";

        response.then().assertThat().statusCode(200);

        String actualData = response.getBody().asString();

        Assert.assertEquals(expectedData,actualData);



    }



******************



@Test

    public void task04(){

        specification.pathParams("vehiclesPath","vehicles","idPath","4");



        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");



        response.prettyPrint();



        response.then().assertThat().statusCode(200);



       String actualData = response.getBody().asString();



        String expectedData ="{\n" +

                "    \"name\": \"Sand Crawler\",\n" +

                "    \"model\": \"Digger Crawler\",\n" +

                "    \"manufacturer\": \"Corellia Mining Corporation\",\n" +

                "    \"cost_in_credits\": \"150000\",\n" +

                "    \"length\": \"36.8 \",\n" +

                "    \"max_atmosphering_speed\": \"30\",\n" +

                "    \"crew\": \"46\",\n" +

                "    \"passengers\": \"30\",\n" +

                "    \"cargo_capacity\": \"50000\",\n" +

                "    \"consumables\": \"2 months\",\n" +

                "    \"vehicle_class\": \"wheeled\",\n" +

                "    \"pilots\": [\n" +

                "        \n" +

                "    ],\n" +

                "    \"films\": [\n" +

                "        \"https://swapi.dev/api/films/1/\",\n" +

                "        \"https://swapi.dev/api/films/5/\"\n" +

                "    ],\n" +

                "    \"created\": \"2014-12-10T15:36:25.724000Z\",\n" +

                "    \"edited\": \"2014-12-20T21:30:21.661000Z\",\n" +

                "    \"url\": \"https://swapi.dev/api/vehicles/4/\"\n" +

                "}";



        Assert.assertEquals("Eşit değil..",expectedData,actualData);

    }





     */
}
