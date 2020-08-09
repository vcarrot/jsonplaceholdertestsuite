/* This test is to check the response body after doing a valid POST call to the API to add a new comment to a post */
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
import java.util.*;

@Test
public class PostCommentResponseBodyTest {
    public static void TestPostCommentResponseBody(){
        String nameString = "NAME STRING GOES HERE";
        String emailString = "TEST EMAIL ADDRESS GOES HERE";
        String bodyString = "BODY STRING GOES HERE";
        int postId = 3;

        String expectedStringResponse = "{\n" +
                "  \"name\": \"" +nameString+ "\",\n" +
                "  \"body\": \"" + bodyString +"\",\n" +
                "  \"email\": \""+ emailString +"\",\n" +
                "  \"postId\": \"3\",\n" +
                "  \"id\": 501\n" +
                "}";

        Map<String,String> commentMap = new HashMap<String,String>();
        commentMap.put("name", nameString);
        commentMap.put("email", emailString);
        commentMap.put("body", bodyString);

        String stringResponse = RestHelpers.postCommentsResponseBody(commentMap, postId);
        Assert.assertEquals(stringResponse, expectedStringResponse, "Response after valid POST call is incorrect.");
    }
}
