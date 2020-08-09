/* This test checks that we can filter the posts endpoint by a parameter*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;
@Test
public class GetPostsWithParamCountTest {
    public static void TestGetPostsWithParamCount(){
        int userId = 1; //set this as a variable in case we want to set environment specific variables later or grab this dynamically
        String stringResponse = RestHelpers.getPostsBody(userId);
        int numberPosts = JsonHelpers.jsonArraySize(stringResponse);
        Assert.assertTrue((numberPosts > 0),"Specifying a userID did not bring back any posts");
    }
}
