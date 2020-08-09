/* This tests checks the status code returned from a valid PUT call to update an existing post */
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
import java.util.*;

@Test
public class PutUpdatePostStatusCodeTest {
    public static void TestPutUpdatePostStatusCodeTest(){
        String titleString = "TEST TITLE GOES HERE";
        String bodyString = "POST BODY GOES HERE";
        int postId = 3;
        //hardcode a known valid json map
        Map<String,String> postMap = new HashMap<String,String>();
        postMap.put("title", titleString);
        postMap.put("body", bodyString);
        postMap.put("userId", "2");

        int returnStatusCode = RestHelpers.putPostUpdateStatusCode(postMap, postId);
        Assert.assertEquals(returnStatusCode,200, "PUT /posts returns incorrect status code after updating post with valid response");
    }
}
