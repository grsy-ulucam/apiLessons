

package getRequest;



import BaseURLs.DummyRestApiBaseURL;


import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import org.junit.Test;
import org.testng.Assert;


import java.util.List;



import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Get07 extends DummyRestApiBaseURL {



        /*

         Given

                https://dummy.restapiexample.com/api/v1/employees

         When

             Kullanıcı GET Methodu ile Request Gönderir

         Then

              Status Code un "200" olduğunu Assert et

         And

              employee_age i 55'ten büyük olanları konsola yazdırınız.

              8 tane olduğunu assert ediniz.

         And

             id si 17 den büyük olanları konsola yazdırınız

             7 tane olduğunu assert ediniz.

         And

             salary si 100.000'den az olanları konsola yazdırınız.

             Doris Wilder'ın bunlardan biri olduğunu assert ediniz.



      */



    @Test

    public void get07(){



        /*

        1) Set URL

        2) Set Expected Data

        3) Send a Request

        4) Assertion

         */









        // STep 1: Set URL

        //https://dummy.restapiexample.com/api/v1/employees

        specification.pathParam("employeesPath","employees");





        // Step 2: Expected Data (ignored)





        // Step 3: Send a request



        Response response = given().

                spec(specification).

                when().

                get("/{employeesPath}");



        response.prettyPrint(); // like syso





        //Step 4: Assertion



        /*

         Status Code un "200" olduğunu Assert et



        And

		     employee_age i 55'ten büyük olanları konsola yazdırınız.

		     8 tane olduğunu assert ediniz.

		And

            id si 17 den büyük olanları konsola yazdırınız

            7 tane olduğunu assert ediniz.

        And

            salary si 100.000'den az olanları konsola yazdırınız.

            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.

         */



        JsonPath jsonPath = response.jsonPath();





        // Test 1: employee_age



/*

        List<Integer> employeeAges = jsonPath.getList("data.employee_age");

        System.out.println("employeeAges: " + employeeAges);



        int count = 0;

        for (Integer w : employeeAges) {

            if (w>55){

                count++;

            }

        }

        System.out.println("Count: " + count);

        assertEquals(8,count);
*/

      List<Integer>emp=jsonPath.getList("data.employee_age");
        System.out.println("employeeAges: " +emp);

     int count=0;

        for (Integer s:emp) {
            if (s>55){
                count++;
            }


        }
        System.out.println("employes:" + count);

     assertEquals(8,count);

        // Test 2:  id

        //7 tane olduğunu assert et


        List<Integer>id=jsonPath.getList("data.id");

        System.out.println("idnames " + id);

        int count1=0;

        for (Integer s:id) {
            if (s>17){
                count1++;
            }


        }
        System.out.println("idsaysı:" + count1);

        assertEquals(7,count1);



        List<Integer> idS = jsonPath.getList("data.findAll{(it.id)>17}.id");

        System.out.println("İDs: " + idS);

        assertEquals(7,idS.size());


  //  List<Integer>id=jsonPath.getList("data.findAll{(it.id)>17}.id");


    System.out.println("id = " + id);

    assertEquals(24,id.size());

    /* And
    salary si 100.000'den az olanları konsola yazdırınız.
    Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
*/


        List<Integer> listSalary2=jsonPath.getList("data.findAll{it.employee_salary<100000}.employee_name");

        System.out.println("listSalary2 = " + listSalary2);





    }






}

