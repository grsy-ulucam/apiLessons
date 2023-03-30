package homework;


import io.restassured.response.Response;

import org.junit.Test;



import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;


public class test02 {

      /*

      Given

          https://restful-booker.herokuapp.com/booking/78100

      When

          Kullanıcı GET Methodu ile Request Gönderir

      Then

          Status Code un "404" olduğunu Assert et

      And

          Response Body nin "Not Found" olduğunu assert et

      And

          Headers dan Via nın "1.1 vegur" olduğunu assert et.

      And

          Response body nin "Clarusway" yazmadığını assert et

      And

          Status Line "HTTP/1.1 404 Not Found" olduğunu assert et.



       */

    @Test

    public void test02() {




        /*

        4 adımdan oluşuyordu.



        1) Set URL

        2) Set Expected Data   --> şu an için ignore edeceğim

        3) Send Request

        4) Assertion



         */

       String URL ="https://restful-booker.herokuapp.com/booking/78100";

        Response response =given().when().get(URL);
        response.prettyPrint();

       response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

       String responseBodyStr= response.asString();

        System.out.println("Response Body: "  + responseBodyStr);

       assertTrue(responseBodyStr.contains("Not Found"));

       assertEquals("1.1 vegur",response.getHeader("Via"));

      assertFalse(responseBodyStr.contains("Clarusway"));

    }
}
