package getRequest;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class test02 extends JsonPlaceHolderBaseURL {



        /*



           Given

                       https://jsonplaceholder.typicode.com/todos/2

               When

                   Kullanıcı GET Methodu ile Request Gönderir

               Then

                    Status Code un "200" olduğunu Assert et

               And

                   Header da Server ın cloudflare olduğunu Assert et

               And

                    Response body nin bu şekilde olduğunu doğrular

         {

           "userId": 1,

           "id": 2,

           "title": "quis ut nam facilis et officia qui",

           "completed": false

       }

            */

@Test
    public  void  test02(){

    //Step 1 :set url atanır öncesinde base url class oluşturulur .

    //https://jsonplaceholder.typicode.com/todos/2

specification.pathParams("todosPath","todos",
        "idPath","2");


//Step 2:expected data oluştulur.


    JsonPlaceHolderTestData jj=new JsonPlaceHolderTestData();

    HashMap<String,Object>expectedData=jj.setUpDataTodos();

    System.out.println("expectedData = " + expectedData);


// Step 3:Send a Request


    Response response=given().
            spec(specification) .
            when().
            get("/{todosPath}/{idPath}");

    System.out.println("Response");

    response.prettyPrint();

    //Step 4:Actual data oluşturulur

    HashMap<String,Object>actualdata=response.as(HashMap.class);

    System.out.println("actualdata = " + actualdata);

   Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));

   Assert.assertEquals(expectedData.get("StatusCode"),response.statusCode());
   Assert.assertEquals(expectedData.get("id"),actualdata.get("id"));
   Assert.assertEquals(expectedData.get("completed"),actualdata.get("completed"));
   Assert.assertEquals(expectedData.get("title"),actualdata.get("title"));











}











}
