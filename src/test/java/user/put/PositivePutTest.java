package user.put;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.common.create.UserCreate;
import petstore.models.User;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_USER_TEMPLATE;

public class PositivePutTest extends UserBaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(USER, user);
    }

    @Test
    public void putUserWithFieldsPositive() {
        User user = UserCreate.minUserCreate();
        Response response = Requests.put(USER, user);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "User creation failed");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }
}
