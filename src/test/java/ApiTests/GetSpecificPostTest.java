/* This test checks that we can specific which post and then grab a value from the pulled post*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;

@Test
public class GetSpecificPostTest {
    public static void TestGetSpecificPost(){
        int postId = 1;
        String stringResponse = RestHelpers.getSpecificPostBody(postId);
        String pulledPostID = JsonHelpers.jsonValueFromKey(stringResponse,"id");
        Assert.assertEquals(String.valueOf(postId),pulledPostID, "id value of pulled response does not match expected");
    }
}
