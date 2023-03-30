package deleteRequest;

import BaseURLs.RestFullBookerHerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class test01 extends RestFullBookerHerOkuAppBaseURL {
    @Test
    public void delete01() {
        // https://restful-booker.herokuapp.com/booking/1
        // step1;
        specification.pathParams("bookingPath", "booking", "idPath", "1");

        //step2;

        //step3;

        Response response = given()
                .spec(specification).
                contentType(ContentType.JSON).
                when().
                header("Cookie", "token=" + "031b10a5c61de48")
                .delete("/{bookingPath}/{idPath}");

        System.out.println("RESPONSE");

        response.prettyPrint();




    }
}