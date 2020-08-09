/* This test ensures that GET /posts return matches the given JSON Schema
* I guessed at the schema but in a real scenario, we could look at the application code or ask a dev*/
package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;

@Test
public class GetPostsJsonSchemaTest{

    public static void TestGetCommentsValidJson(){
        String responseBody = RestHelpers.getPostsBody();
        boolean matchesSchema = JsonHelpers.jsonObjMatchesSchema(responseBody, "src/test/java/JsonSchemas/PostsSchema.json");
        Assert.assertTrue(matchesSchema, "Posts API response matches Posts Schema");
    }
}
