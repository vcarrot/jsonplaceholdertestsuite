package ApiTests;

import org.testng.annotations.*;
import org.testng.Assert;
import HelperClasses.*;


@Test
public class HelloWorldTest {
    public static void main() {
        boolean bool = RestHelpers.RestHelperMethod();
        Assert.assertTrue(bool,"The test works");
    }
}
