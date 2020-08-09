/* This test ensures that GET /posts/{postID}/comments return matches the given JSON Schema
 * I guessed at the schema but in a real scenario, we could look at the application code or ask a dev*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;

@Test
public class GetCommentsJsonSchemaTest {
    public static void TestGetCommentsJsonSchema(){
        int postId = 3;
        String responseBody = RestHelpers.getCommentsBody(postId);
        boolean matchesSchema = JsonHelpers.jsonObjMatchesSchema(responseBody, "src/test/java/JsonSchemas/CommentsSchema.json");
        Assert.assertTrue(matchesSchema, "Comments API response matches Comments Schema");
    }
}
