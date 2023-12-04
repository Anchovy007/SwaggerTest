package user.post.user;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.common.create.UserCreate;
import petstore.models.User;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_USER_TEMPLATE;

public class PositiveCreateUserPostTest extends UserBaseTests {

    @Test
    public static void postCreateUserPositive() {
        Response response = Requests.post(USER, user);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Pet creation failed");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }

    @Test
    public static void postCreateUserFieldsPositive() {
        User user = UserCreate.minUserCreate();
        Response response = Requests.post(USER, user);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Pet creation failed");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }
}
