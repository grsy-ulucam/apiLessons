package homework;

import BaseURLs.RestapiExampleBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class day03 extends RestapiExampleBaseURL {
 /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/
 @Test
    public  void  day03() {

     specification.pathParams("employeePath", "employee",
             "idPath", "1");


     Response response = given()
             .spec(specification).
             when().
             get("/{employeePath}/{idPath}");

     response.prettyPrint();

     response.then().assertThat().

             statusCode(200).

             contentType(ContentType.JSON).

             body("status",equalTo("success"));






















    }
}
