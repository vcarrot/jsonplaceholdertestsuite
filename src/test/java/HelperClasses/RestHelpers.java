/*
RestHelpers are reusable methods that directly interact with the APIs
*/
package HelperClasses;

import io.restassured.RestAssured;
import io.restassured.specification.*;
import io.restassured.response.*;
import io.restassured.http.*;


public class RestHelpers {

    public static String getPostsBody(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static int getPostsStatusCode(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

}
