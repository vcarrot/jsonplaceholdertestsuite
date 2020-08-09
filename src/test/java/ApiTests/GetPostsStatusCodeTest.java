/* This test ensures that GET /posts returns a 200 Status Call*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;

@Test
public class GetPostsStatusCodeTest{

    public static void TestGetPostsStatusCode() {
        int statusCode = RestHelpers.getPostsStatusCode();
        Assert.assertEquals(statusCode, 200, "GET /posts Status Code is incorrect");
    }

}
