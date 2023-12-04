package user.post.userCreateWithArray;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.common.create.PetCreate;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_CREATE_WITH_ARRAY;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_PET_TEMPLATE;

public class PositivePostTest extends UserBaseTests {

    @Test
    public void postArrayNewUsersWithAllFieldsPositive() {
        Response response = Requests.post(USER_CREATE_WITH_ARRAY, user, user, user);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Users creation failed");
    }
}

