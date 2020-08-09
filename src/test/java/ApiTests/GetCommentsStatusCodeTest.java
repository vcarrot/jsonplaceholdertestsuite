/* This test ensures that GET /posts/{postID}/comments returns a 200 Status Call given postID exists*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;

@Test
public class GetCommentsStatusCodeTest {
    public static void TestGetCommentsStatusCode(){
        int postId = 3;
        int statusCode = RestHelpers.getCommentsStatusCode(postId);
        Assert.assertEquals(statusCode, 200, "GET /posts Status Code is incorrect");
    }
}
