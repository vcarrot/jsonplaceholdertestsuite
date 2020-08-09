/*
HelperMethods are reusable methods that we will need for the tests
*/
package HelperClasses;

import io.restassured.RestAssured.*;
import org.everit.json.schema.*;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.*;
import java.io.*;
import java.io.FileInputStream;


public class JsonHelpers {
    public static boolean HelperMethod(){
        return true;
    }

    public static boolean jsonObjMatchesSchema(String responseBody, String schemaPath){
        JSONArray jsonArray = stringToJsonArray(responseBody);
        Schema Schema = createSchemaObject(schemaPath);
        Schema.validate(jsonArray);
        return true;
    }

    public static int jsonArraySize(String responseBody){
        JSONArray jsonArray = stringToJsonArray(responseBody);
        int size = jsonArray.length();
        return size;
    }

    private static JSONArray stringToJsonArray(String responseBody){
        JSONTokener jsonTokener = new JSONTokener(responseBody);
        JSONArray jsonArray = new JSONArray(jsonTokener);
        return jsonArray;
    }

    private static Schema createSchemaObject(String schemaFilePath) {
        FileInputStream jsonStream;
        try {
            jsonStream = new FileInputStream(schemaFilePath);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        JSONTokener jsonTokener = new JSONTokener(jsonStream);
        JSONObject schemaObject = new JSONObject(jsonTokener);
        Schema Schema = SchemaLoader.load(schemaObject);
        return Schema;
    }
}
