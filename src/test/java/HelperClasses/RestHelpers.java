/*
RestHelpers are reusable methods that directly interact with the APIs
*/
package HelperClasses;

import io.restassured.RestAssured;
import io.restassured.specification.*;
import io.restassured.response.*;
import io.restassured.http.*;


public class RestHelpers {

    public static String basePostsURI = "https://jsonplaceholder.typicode.com/posts";

    public static String getPostsBody(){
        Response response = getResponseFromURI(basePostsURI);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static String getPostsBody(int userId){
        //overloads above method to grab all posts from a specific userId
        String userIdUriString = basePostsURI + "?userId=" + String.valueOf(userId);
        Response response = getResponseFromURI(basePostsURI);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static int getPostsStatusCode(){
        Response response = getResponseFromURI(basePostsURI);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    private static Response getResponseFromURI(String uriString){
        RestAssured.baseURI = uriString;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        return response;
    }

}
