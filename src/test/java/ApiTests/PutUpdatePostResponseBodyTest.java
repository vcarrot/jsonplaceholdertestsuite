/* This tests checks the response returned from a valid PUT call to update an existing post */
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
import java.util.*;

@Test
public class PutUpdatePostResponseBodyTest {
    public static void TestPutUpdatePostResponseBody(){
        String titleString = "TEST TITLE GOES HERE";
        String bodyString = "POST BODY GOES HERE";
        int postId = 3;
        String expectedStringResponse = "{\n" +
                "  \"body\": \"" + bodyString +"\",\n" +
                "  \"userId\": \"2\",\n" +
                "  \"id\": " + String.valueOf(postId) + "\n" +
                "}";
        //hardcode a known valid json map
        Map<String,String> postMap = new HashMap<String,String>();
        postMap.put("body", bodyString);
        postMap.put("userId", "2");

        String responseBody = RestHelpers.putPostUpdateResponseBody(postMap,postId);
        Assert.assertEquals(responseBody, expectedStringResponse, "Response after valid PUT update call is incorrect.");
    }
}
