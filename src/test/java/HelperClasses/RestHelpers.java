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
        String responseBody = responseFromURI(basePostsURI, "GET").getBody().asString();
        return responseBody;
    }

    public static String getPostsBody(int userId){
        //overloads above method to grab all posts from a specific userId
        String userIdUriString = basePostsURI + "?userId=" + String.valueOf(userId);
        String responseBody = responseFromURI(userIdUriString, "GET").getBody().asString();
        return responseBody;
    }

    public static String getSpecificPostBody(int postId){
        String specificPostUriString = basePostsURI + "/" + String.valueOf(postId);
        String responseBody = responseFromURI(specificPostUriString, "GET").getBody().asString();
        return responseBody;
    }

    public static int getPostsStatusCode(){
        Response response = responseFromURI(basePostsURI, "GET");
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    //GET Comments Methods //

    public static int getCommentsStatusCode(int postId){
        String commentsURI = buildCommentsURI(postId);
        int statusCode = responseFromURI(commentsURI, "GET").getStatusCode();
        return statusCode;
    }

    public static String getCommentsBody(int postId){
        String commentsURI = buildCommentsURI(postId);
        String responseBody = responseFromURI(commentsURI, "GET").getBody().asString();
        return responseBody;
    }

    // POST and PUT Posts Methods //

    public static int postPostsStatusCode(Map<String,String> myMap){
        int statusCode = responseFromURI(basePostsURI, myMap, "POST").getStatusCode();
        return statusCode;
    }

    public static String postPostsResponseBody(Map<String,String> myMap){
        String responseBody = responseFromURI(basePostsURI, myMap, "POST").getBody().asString();
        return responseBody;
    }

    public static int putPostUpdateStatusCode(Map<String,String> myMap,int postId){
        String specificPostURI = basePostsURI + "/" + String.valueOf(postId);
        int statusCode = responseFromURI(specificPostURI, myMap, "PUT").getStatusCode();
        return statusCode;
    }

    public static String putPostUpdateResponseBody(Map<String,String> myMap,int postId) {
        String specificPostURI = basePostsURI + "/" + String.valueOf(postId);
        String responseBody = responseFromURI(specificPostURI, myMap, "PUT").getBody().asString();
        return responseBody;
    }

    // PUT and POST Comments Methods //

    public static String postCommentsResponseBody(Map<String,String> myMap, int postId){
        String commentsURI = buildCommentsURI(postId);
        String responseBody = responseFromURI(commentsURI, myMap, "POST").getBody().asString();
        return responseBody;
    }

    private static String buildCommentsURI(int postId){
        String commentsURI = basePostsURI + "/" + String.valueOf(postId) + "/comments";
        return commentsURI;
    }

    // private methods go below here

    private static Response responseFromURI(String uriString, String callType){
        //to be used for GET and DELETE methods
        RestAssured.baseURI = uriString;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = null;
        switch(callType){
            case "GET":
                response = httpRequest.request(Method.GET);
                break;
            case "DELETE":
                response = httpRequest.request(Method.DELETE);
                break;
        }
        return response;
    }

    private static Response responseFromURI(String uriString, Map<String,String> myMap, String callType){
        //to be used for PUT and POST methods
        RestAssured.baseURI = uriString;
        RequestSpecification request = mapToRequest(myMap);
        Response response = null;
        switch(callType){
            case "PUT":
                response = request.request(Method.PUT);
                break;
            case "POST":
                response = request.request(Method.POST);
                break;
        }
        return response;
    }

    private static RequestSpecification mapToRequest(Map<String,String> myMap){
        JSONObject jsonObj = JsonHelpers.jsonObjectFromMap(myMap);
        RequestSpecification request = RestAssured.given();
        request.header("Content-type", "application/json; charset=UTF-8");
        request.body(jsonObj.toString());
        return request;
    }


}
