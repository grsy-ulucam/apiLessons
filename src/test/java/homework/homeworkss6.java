package homework;

import BaseURLs.RestFullBookerHerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.Restfullmapdisi;
import pojoDatas.Restfullmapici;
import utilities.JsonToJava;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@JsonIgnoreProperties(ignoreUnknown = true)


    public class homeworkss6 extends RestFullBookerHerOkuAppBaseURL {
        /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "additionalneeds": "Full Stack Test Automation Course with API and Appium",
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }

             }
        When
          Kullanıcı POST metodu ile request göderir
       Then
              Status Code un 200 olduğu doğrulanır
      And
            Response Body nin aşağıdaki gibi olduğu verify edilir
          {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */

        @Test
        public void odevvv() {

            // Set URL
            //https://restful-booker.herokuapp.com/booking
            specification.pathParam("bookingPath", "booking");


            // Step 2

            Restfullmapici restfullmapici = new Restfullmapici("2022-09-05", "2023-06-01");
            Restfullmapdisi restfullmapdisi = new Restfullmapdisi("Drake", "F.", 4000, true, "Full Stack Test Automation Course with API and Appium", restfullmapici);

            //System.out.println("restfullmapdisi = " + restfullmapdisi);

            //Step 3

            Response response = given().
                    spec(specification).
                    contentType(ContentType.JSON).
                    body(restfullmapdisi).when().
                    post("/{bookingPath}");

            System.out.println("Response ;");
            response.prettyPrint();

            //Step 4

            Map<String,Object>actualData= JsonToJava.convertJsonToJavaObject(response.asString(),Map.class);

            System.out.println("actualData = " + actualData);

            response.then().assertThat().statusCode(200);


            JsonPath jsonPath=new JsonPath(response.asString());

            assertEquals(restfullmapdisi.getLastname(),jsonPath.getString("booking.lastname"));
            assertEquals(restfullmapdisi.getFirstname(),jsonPath.getString("booking.firstname"));
            assertEquals(restfullmapdisi.getTotalprice(),jsonPath.get("booking.totalprice"));
            assertEquals(restfullmapdisi.getDepositpaid(),jsonPath.get("booking.depositpaid"));
            assertEquals(restfullmapici.getCheckin(),jsonPath.get("booking.bookingdates.checkin"));
            assertEquals(restfullmapici.getCheckout(),jsonPath.get("booking.bookingdates.checkout"));
            assertEquals(restfullmapdisi.getAdditionalneeds(),jsonPath.get("booking.additionalneeds"));

          

        }


}

