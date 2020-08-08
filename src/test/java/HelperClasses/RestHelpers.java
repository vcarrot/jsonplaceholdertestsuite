/*
RestHelpers are reusable methods that directly interact with the APIs
*/
package HelperClasses;

import io.restassured.RestAssured;
import io.restassured.specification.*;
import io.restassured.response.*;
import io.restassured.http.*;
import io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

public class RestHelpers {
    public static boolean RestHelperMethod(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/employees");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        return responseBody.isEmpty();
    }

}
