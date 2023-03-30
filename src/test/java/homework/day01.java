package homework;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class day01 {

    /*
https://jsonplaceholder.typicode.com/todos/2/*Status code is 200
	And "completed" is false
	And "userId" is
	1 And "title" is "quis ut nam facilis et officia qui«
	And header "Via" is "1.1 Vegur«
	And header "Server" is "cloudflare«
	And title is contains "qui«
     */

@Test
    public  void myHomework() {

    String URL = "https://jsonplaceholder.typicode.com/todos/2";

    Response response = given().accept("application/json").when().get(URL);

    response.then().assertThat().statusCode(200);

    response.then().assertThat().body("completed", equalTo(false));

    Assert.assertTrue(response.asString().contains("\"completed\": false"));

    response.then().assertThat().body("userId", equalTo(1));

    response.then().assertThat().body("title", equalTo("quis ut nam facilis et officia qui"));

    response.then().assertThat().headers("Via", equalTo("1.1 vegur"));

    response.then().assertThat().headers("Server", equalTo("cloudflare"));

    response.then().assertThat().body("title", containsString("qui"));

}
}
