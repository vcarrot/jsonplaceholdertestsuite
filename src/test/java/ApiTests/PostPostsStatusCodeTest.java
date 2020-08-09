/* This tests checks the status code returned from a valid POST call to add a new post */
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
import java.util.*;

@Test
public class PostPostsStatusCodeTest {
    public static void TestPostPostsStatusCode(){
        //hardcode a known valid json map
        Map<String,String> postMap = new HashMap<String,String>();
        postMap.put("title", "TEST TITLE GOES HERE");
        postMap.put("body", "POST BODY GOES HERE");
        postMap.put("userId", "2");

        int returnStatusCode = RestHelpers.postPostsStatusCode(postMap);
        Assert.assertEquals(returnStatusCode,201, "POST /posts returns incorrect status code after posting valid response");
    }
}
