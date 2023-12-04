package petstore.validator;

import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static petstore.validator.ValidationTemplatePaths.*;


public class JsonValidator {

    public static void validateObject(Response response,String path) {
        try {
            String requestResponse = response.asString();
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(path)));
            JSONObject jsonSubject = new JSONObject(new JSONTokener(requestResponse));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void validateList(String response) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(PATH_TO_PETLIST_TEMPLATE)));
            JSONArray jsonSubject = new JSONArray(new JSONTokener(response));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}