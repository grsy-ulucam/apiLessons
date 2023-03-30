package homework;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class test03  extends JsonPlaceHolderBaseURL {

     /*

                Given

                    https://jsonplaceholder.typicode.com/todos/2

                When

                     Kullanıcı GET Methodu ile Request Gönderir

                Then

                    Status Code un "200" olduğunu Assert et

                And

                    Content Type ın "application/json" olduğunu assert et

                And

                    title ın “quis ut nam facilis et officia qui” olduğunu verify et.,

                And

                    “completed” ın false olduğunu verify et.

                And

                    “userId” in 1 olduğunu verify et

             */





        /*

        {

        "userId": 1,

        "id": 2,

        "title": "quis ut nam facilis et officia qui",

        "completed": false

    }

         */

 @Test
    public  void  test03(){

     // Step 1: Set URL:  https://jsonplaceholder.typicode.com/todos/2


     specification.pathParams("todosPath","todos","idPath","2");

    // Send Request
     Response response =given()
             .spec(specification)
             .when()
             .get("/{todosPath}/{idPath}");

     response.prettyPrint();

     response.
             then().
             assertThat().
             statusCode(200).
             contentType(ContentType.JSON).
             body("title",equalTo("quis ut nam facilis et officia qui"),
                     "completed",equalTo(false),
                     "userId",equalTo(1));


      //2 .way

  response.then().assertThat().statusCode(200).contentType("application/json");

    response.
            then().
            assertThat().
            body("title", Matchers.equalTo("quis ut nam facilis et officia qui"),
     "completed",Matchers.equalTo(false),
     "userId",Matchers.equalTo(1));


 }

}
