package user.get.username;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.*;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_STRICT;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_USER_TEMPLATE;

public class NegativeGetIdTest extends UserBaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(USER, user);
        Requests.delete( USER_STRICT + user.getUsername());
    }

    @Test
    public static void getByUsernameNegativeNonexistentUsername() {
        Response response = Requests.get(USER_STRICT + "AAA");
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Username with this name exists");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }

    @Test
    public static void getByUsernameNegativeDeletedUsername() {
        Requests.delete( USER_STRICT + user.getUsername());
        Response response = Requests.get(USER_STRICT + user.getUsername());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Username with this name exists");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }

}
