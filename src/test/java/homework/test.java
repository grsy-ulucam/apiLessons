package homework;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class test {
    @Test
    public  void myHomework() {
        String URL = "https://jsonplaceholder.typicode.com/todos/2";

        Response response = given().accept("application/json").when().get(URL);

        response.then().assertThat().statusCode(200);

        response.then().assertThat().body("completed",equalTo(false));

        response.then().assertThat().body("userId",equalTo(1));

        response.then().assertThat().body("title",equalTo("quis ut nam facilis et officia qui"));


        response.then().assertThat().headers("Via",equalTo("1.1 vegur"));

        response.then().assertThat().headers("Server",equalTo("cloudflare"));

        response.then().assertThat().body("title",containsString("qui"));

    }
}
