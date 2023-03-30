

package postRequest;



import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import pojoDatas.CryptoCurrencyPojo;

import pojoDatas.CustomerInfoPojo;

import testData.BitPaceGetToken;



import java.util.HashMap;

import java.util.Map;



import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;



public class Post04 {

     /*
      "token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJoOER5QjYxdTFvTy1lSERSZ0lYMTUwY3l1YzNSWmFTbDNlS0RQWjY3c1BzIn0.eyJqdGkiOiI2ZmE4N2UwZC1lZGY4LTRiNWMtYTgwNS00YWJlM2Q4YmJmNTAiLCJleHAiOjE2Nzc4NzMxODcsIm5iZiI6MCwiaWF0IjoxNjc3ODM3MTg3LCJpc3MiOiJodHRwczovL2F1dGgtc2FuZGJveC5iaXRwYWNlLmNvbS9hdXRoL3JlYWxtcy9iaXRwYWNlIiwic3ViIjoiMzllYzMyZDEtMDllOS00ZTkxLTk5ZjAtMGM5MDYyNGVkOGE1IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoibWVyY2hhbnQtYXBpIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMGVmOTFkYzgtYWE2Ny00ODMyLTllYWQtNGE0NTQwNTE4MDBlIiwiYWNyIjoiMSIsInNjb3BlIjoicHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJyb2xlcyI6WyJXSVRIRFJBVyIsIlBBWU1FTlQiLCJTRUxMIiwiQlVZIiwiREVQT1NJVCJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiIyMDYyNTEyMzQyNSIsIm1lcmNoYW50X2lkIjoiNDE4In0.a_AHhNSlTP9gmtRyCOBmt8nHeilikOAOSpVhdiR__ehbSmgiOl1cRUGzRwZxy58a3IpwfRliAOjpFqgbPI7Pt7b8iSqlwzcV8Mvt9o2MSwZBIcuyFklDktqu8SO26769xEBKogeP2UeBGUnUpJYxdds-4UMehpCGKfePOY6Xdyn-_LlkgoszICEhHW6NH3UivP_juh1rntUvzMAKg8Y9Ip3LUu9a5_r50eLlF1UkCL6frT2emhd_6c_4vbMwg-cXH7ysfVdFNfDiAcH2O95qv58ppLMifrf1wxHlnkpMJH8vLlky_vQm_om9Kx9rHlrRWVJNOQbTXqA7IukLk5G-ZA"
    },
      */

        

        /*
  
         this is important ->https://dev.bitpace.com/bitpace-merchant-rest-api#introduction    ŞİFRE: XHa:74!0p0
  
      API Doc. URL ====>>>>>   !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!!
  
  
  
      Given
  
          https://api-sandbox.bitpace.com/api/v1/auth/token adresine POST metodu  ile request atılıp token alınmalı.
  
  
  
         Kullanılacak Request Body:
  
              {
  
      "merchant_code":"20625123425",
  
      "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
  
  }
  
  
  
  
  
      Token alındıktan sonra aşğaıdaki işlemlere geçebiliriz.
  
          https://api-sandbox.bitpace.com/api/v1/customer/deposit/address
  
  
  
          **Alınan Token Headers ta Bearer Auth. olarak gçnderilecektir.**
  
  
  
      When
  
         Kullanıcı POST metodu ile request atar
  
  
  
         Kullanılacak Request Body:
  
          {
  
      "cryptocurrency": "BTC",
  
      "customer": {
  
          "reference_id": "20625123425",
  
          "first_name":"",
  
          "last_name":"",
  
          "email":"drakeF@gmail.com"
  
      }
  
  }
  
      Then
  
          Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
  
          Expected message "Response Approved" içermeli
  
  
  
       */

        

        // https://dev.bitpace.com/bitpace-merchant-rest-api  adresine giderek

        //customer deposit adress gerçekleştiriniz.

        

        

        

    // https://api-sandbox.bitpace.com/api/v1

    String URL = "https://api-sandbox.bitpace.com/api/v1/";

    public String token;



    @Before

    //@Test

    public void postforToken(){

        //Bu metot işlemlerimi yapabilmek için

        //token create eden bir metotdur.



        //Set URL,

        //https://api-sandbox.bitpace.com/api/v1/auth/token

        String URLForToken = URL + "auth/token";



        //Set Req Body

        BitPaceGetToken bitPaceGetToken = new BitPaceGetToken();

        Map<String,String> reqBodyMap = bitPaceGetToken.reqTestDataBody();



        // System.out.println("ReqBodyMap: " + reqBodyMap);





        //Send a Request

        Response response = given().

                contentType(ContentType.JSON).

                body(reqBodyMap).//merhac doe and paasword

                        when().

                post(URLForToken);

        // System.out.println("Response: ");

        // response.prettyPrint();





        //Step 4: Assertion

        // Fakat bu case ben 4. step de RESPONSE dan token alacağım

        /*

        {

    "data": {

        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudElkIjoxLCJ0aW1lc3RhbXAiOjE1NDU4MjIwODd9.e_Qj_IgyZg09m5nJToQVZRDwVGJLTKLTgs0I3H9_uKM"

    },

    "code": "00",

    "message": "APPROVED",

    "status": "APPROVED"

}

         */

        JsonPath jsonPath = response.jsonPath();

        token = jsonPath.getString("data.token");

        //System.out.println("Token: \n" + token);





    }



    @Test

    public void createDepositWithPost(){



        //Set URL

        //https://api-sandbox.bitpace.com/api/v1/customer/deposit/address

        String URLforCreationDeposit = URL + "customer/deposit/address";





        //Step 2: Set Req Body



        /*  Kullanılacak Request Body:

        {

    "cryptocurrency": "BTC",

    "customer": {

        "reference_id": "20625123425",  //merch.code

        "first_name":"",

        "last_name":"",

        "email":"drakeF@gmail.com"

    }

}

    Then

        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.

        Expected message "Response Approved" içermeli



     */



        CustomerInfoPojo customerInfoPojo = new CustomerInfoPojo("20625123425","","","drakeF@gmail.com");

        CryptoCurrencyPojo reqBody = new CryptoCurrencyPojo("BTC",customerInfoPojo);








        // Step 3: Send a request;



        /*



                body(reqBodyAndExpectedDataMap).

                when().

                header("Authorization","Bearer c0aa77eb8a368a7d991c8e10e6afb9756130abe80e29a6826477f8645165c7b0").

                post("/{usersPath}");

         */

        Response response = given().

                contentType(ContentType.JSON).

                body(reqBody).

                when().

                header("Authorization","Bearer " + token).

                post(URLforCreationDeposit);



        System.out.println("RESPONSE: ");

        response.prettyPrint();


        System.out.println("*************************");


        //Step 4: Assertion

        /*

         Then

        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.

        Expected message "Response Approved" içermeli

         */



        Map<String,Object> actualDataFromRESPONSE = response.as(HashMap.class);

        System.out.println("actualDataFromRESPONSE: " + actualDataFromRESPONSE);



        assertEquals("Response Approved",actualDataFromRESPONSE.get("message"));
        assertEquals("APPROVED",actualDataFromRESPONSE.get("status"));
        assertEquals("00",actualDataFromRESPONSE.get("code"));













    }



        

        

        

}

