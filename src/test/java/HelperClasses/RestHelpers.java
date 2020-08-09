/*
RestHelpers are reusable methods that directly interact with the APIs
*/
package HelperClasses;

import io.restassured.RestAssured;
import io.restassured.specification.*;
import io.restassured.response.*;
import io.restassured.http.*;
import org.json.*;
import java.util.*;


public class RestHelpers {

    public static String basePostsURI = "https://jsonplaceholder.typicode.com/posts";

    // GET Posts methods //
    public static String getPostsBody(){
        Response response = getResponseFromURI(basePostsURI);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static String getPostsBody(int userId){
        //overloads above method to grab all posts from a specific userId
        String userIdUriString = basePostsURI + "?userId=" + String.valueOf(userId);
        Response response = getResponseFromURI(userIdUriString);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static String getSpecificPostBody(int postId){
        String specificPostUriString = basePostsURI + "/" + String.valueOf(postId);
        Response response = getResponseFromURI(specificPostUriString);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static int getPostsStatusCode(){
        Response response = getResponseFromURI(basePostsURI);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    //GET Comments Methods

    public static int getCommentsStatusCode(int postId){
        String commentsURI = buildCommentsURI(postId);
        Response response = getResponseFromURI(commentsURI);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    private static String buildCommentsURI(int postId){
        String commentsURI = basePostsURI + "/" + String.valueOf(postId) + "/comments";
        return commentsURI;
    }

    private static Response getResponseFromURI(String uriString){
        RestAssured.baseURI = uriString;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        return response;
    }

    // POST and PUT Posts Methods //

    public static int postPostsStatusCode(Map<String,String> myMap){
        Response response = postResponseFromURI(basePostsURI, myMap);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public static String postPostsResponseBody(Map<String,String> myMap){
        Response response = postResponseFromURI(basePostsURI, myMap);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    public static int putPostUpdateStatusCode(Map<String,String> myMap,int postId){
        String specificPostURI = basePostsURI + "/" + String.valueOf(postId);
        Response response = putResponseFromURI(specificPostURI, myMap);
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public static String putPostUpdateResponseBody(Map<String,String> myMap,int postId) {
        String specificPostURI = basePostsURI + "/" + String.valueOf(postId);
        Response response = putResponseFromURI(specificPostURI, myMap);
        String responseBody = response.getBody().asString();
        return responseBody;
    }

    private static RequestSpecification mapToRequest(Map<String,String> myMap){
        JSONObject jsonObj = JsonHelpers.jsonObjectFromMap(myMap);
        RequestSpecification request = RestAssured.given();
        request.header("Content-type", "application/json; charset=UTF-8");
        request.body(jsonObj.toString());
        return request;
    }

    private static Response postResponseFromURI(String uriString, Map<String,String> myMap){
        RestAssured.baseURI = uriString;
        RequestSpecification request = mapToRequest(myMap);
        Response response = request.request(Method.POST);
        return response;
    }

    private static Response putResponseFromURI(String uriString, Map<String,String> myMap){
        RestAssured.baseURI = uriString;
        RequestSpecification request = mapToRequest(myMap);
        Response response = request.request(Method.PUT);
        return response;
    }


}
