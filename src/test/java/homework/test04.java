package homework;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class test04 extends JsonPlaceHolderBaseURL {

    /*

         Given

             https://jsonplaceholder.typicode.com/users   --> resources farklı

         When

              Kullanıcı GET Methodu ile Request Gönderir

         Then

             Status Code un "200" olduğunu Assert et

         And

             Content Type ın "application/json" olduğunu assert et

         And

             Data uzunluğunun 10 olduğunu assert ediniz.



      */


  @Test
    public  void  test04() {

/*

        1) Set URL

        2) Set Expected ata

        3) Send a Request

        4) assertion

         */

      //Step 1:    https://jsonplaceholder.typicode.com/users

    specification.pathParams("usersPath","users");

      //Step 2: Expected data (ignored)




      //Step 3: Send Request


    Response response=given().
            spec(specification).
            when().
            get("/{usersPath}");

     response.prettyPrint();

      // Step 4: Assertion

       response.
               then().
               assertThat().
               statusCode(200).
               contentType("application/json").
               body("id",Matchers.hasSize(10));








  }

}
