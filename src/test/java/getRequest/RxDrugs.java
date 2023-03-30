package getRequest;

import BaseURLs.RxDrugsURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RxDrugs extends RxDrugsURL {

    @Test
    public void test01() {


        //Set URL
        String token ="eyJraWQiOiIyOGQ1MDVjMy01MDgxLTQwOGEtOGU0NC01NTgzMTYxN2EwYjQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJncm91cDJAdGVzdC5jb20iLCJzdWJfZGVmYXVsdF9tZW1iZXJzaGlwX3R5cGVfaWQiOjUsInN1Yl9pZCI6MjgsInN1Yl9kZWZhdWx0X3N1YnNjcmlwdGlvbl9pZCI6ImJhMzYxYTE5LTVmYmItNDM2Ni1iNDI1LTUwMjMwZjFkNzkxOCIsInN1Yl9hcHAiOjIsImlzcyI6Imh0dHBzOlwvXC9hM20tcWEtZ20zLnF1YXNwYXJlcGFydHMuY29tIiwic3ViX2RlZmF1bHRfb3JnX2lkIjoxLCJhdWQiOiIxNjczOTg1MTg0X1pYc05UN0N1aFR6cmlqbCIsIm5iZiI6MTY4MDA5NTU3Miwic3ViX2RlZmF1bHRfb3JnX25hbWUiOiJSeCBEcnVncyIsInNjb3BlIjpbIlJPTEVfQnVzaW5lc3MgT3duZXIiLCJvcmRlcjp3cml0ZSIsImZpbGU6d3JpdGUiLCJpbnZlbnRvcnk6cmVhZCIsInJlY2VwdGlvbjpjb25maXJtIiwid2lzaGxpc3Q6YXBwcm92ZWQiLCJpbnZvaWNlOnJlYWQiLCJpbnZlbnRvcnk6d3JpdGUiLCJkYXNoYm9hcmQ6cmVhZCIsInVzZXI6d3JpdGUiLCJzcGVjcHJpY2U6cmVhZCIsImFjY291bnRpbmc6d3JpdGUiLCJ1c2VyLWdyb3VwOnJlYWQiLCJzcGVjcHJpY2U6d3JpdGUiLCJjb21wYW55OmFkbWluIiwicHVyY2hhc2luZzpjb25maXJtIiwicmVjZXB0aW9uOnJlYWQiLCJ3aXNobGlzdDpxdWFsaXR5X2NvbmZpcm0iLCJ1c2VyLWdyb3VwOndyaXRlIiwidXNlci1zdGF0dXM6cmVhZCIsImNvdW50cnk6cmVhZCIsInByb2N1cmVtZW50OnJlYWQiLCJjb21wYW55OnJlYWQiLCJjb21wYW55OmZpbl9jb25maXJtIiwid2lzaGxpc3Q6c2V0X2NvZGluZyIsInVzZXItZ3JvdXAtdHlwZTpyZWFkIiwid2lzaGxpc3Q6b2ZmZXJfcmVhZHkiLCJwdXJjaGFzaW5nOnJlYWQiLCJvcmdhbml6YXRpb246cmVhZCIsIndpc2hsaXN0OmFkbWluIiwib3JkZXI6cmVhZCIsImhhbmRtYWRlOndyaXRlIiwid2lzaGxpc3Q6b2ZmZXJfY29uZmlybSIsIndpc2hsaXN0OmNhbmNlbCIsImZpbGU6cmVhZCIsInVzZXI6cmVhZCIsIm9yZ2FuaXphdGlvbi1ncm91cDpyZWFkIiwiaW52b2ljZTp3cml0ZSIsImhhbmRtYWRlOmNvbmZpcm0iLCJyZWNlcHRpb246d3JpdGUiLCJ3aXNobGlzdDpzZXRfcHJpY2UiLCJvcmdhbml6YXRpb246d3JpdGUiLCJyb2xlOnJlYWQiLCJtZW1iZXJzaGlwOnJlYWQiLCJ3aXNobGlzdDpzYWxlX2NvbmZpcm0iLCJvcmdhbml6YXRpb24tZ3JvdXA6d3JpdGUiLCJwdXJjaGFzaW5nOndyaXRlIiwid2lzaGxpc3Q6dmlld19zdXBwX3ByaWNlIiwiaW52b2ljZTpjb25maXJtIiwiaGFuZG1hZGU6cmVhZCIsInByb2N1cmVtZW50OndyaXRlIiwib3JnYW5pemF0aW9uLXN0YXR1czpyZWFkIiwiY29tcGFueTpxdWFsX2NvbmZpcm0iLCJwdXJjaGFzaW5nOnJlYWRfY29zdCIsImFjY291bnRpbmc6cmVhZCIsIm9yZGVyOmNvbmZpcm0iLCJ3aXNobGlzdDpyZWFkIl0sInN1Yl9kZWZhdWx0X3JvbGVfaWQiOjUsImV4cCI6MTY4MDA5NzM3MiwiaWF0IjoxNjgwMDk1NTcyfQ.fplfKhg3WzYy1wxaXPjjn5ceRWvifugXoT0FVDI2paoGt5-lq4UabHEYYqgVnmUcoIfDt0NF1z1Q-kGe9GZ1LEjmfP0VdioIZQVbMf8QX5c5TcEB8qSNGbKnDhSByIVJcXYat6ozZ-I-L80M4EQMKLuWjpUHbe6vvqTDa4ZRb0vvOowkwsEOT_DFqMEYFMUzj_GK1uRdwH5GPMuiOJmIJ9rErLD02xJjcxTU6nHI5EQwDaeTWG-7eMCPU5FFgsBv8OXk1piRg4SCw0O2NFtS2JgBLW2_jm11aP7MXSo4t_4QY5LsRkdwoJerClVDA5mbjO_7WbI7tEMz2EZ-M2sDQg";

        // https://a3m-qa-gm3.quaspareparts.com/auth/api/country

        specification.pathParams("apiPath", "api",

                "countryPath", "country");

        //Expected Data

        //Send a Request

        Response response = given().

                spec(specification).

                when().

                header("Authorization", "token").

                get("/{apiPath}/{countryPath}");

        System.out.println("RESPONSE: ");

        response.prettyPrint();

        //actaul data



    }


}