/* This test is to check the response body after doing a valid POST call to the API to add a new post */
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
import java.util.*;

@Test
public class PostPostsResponseBodyTest {
    public static void TestPostPostsResponseBody(){
        String titleString = "TEST TITLE GOES HERE";
        String bodyString = "POST BODY GOES HERE";
        String expectedStringResponse = "{\n" +
                "  \"title\": \"" +titleString+ "\",\n" +
                "  \"body\": \"" + bodyString +"\",\n" +
                "  \"userId\": \"2\",\n" +
                "  \"id\": 101\n" +
                "}";
        //hardcode a known valid json map
        Map<String,String> postMap = new HashMap<String,String>();
        postMap.put("title", titleString);
        postMap.put("body", bodyString);
        postMap.put("userId", "2");


        String stringResponse = RestHelpers.postPostsResponseBody(postMap);

        Assert.assertEquals(stringResponse, expectedStringResponse, "Response after valid POST call is incorrect.");
    }

}
