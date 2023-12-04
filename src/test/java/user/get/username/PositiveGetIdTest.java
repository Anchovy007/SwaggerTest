package user.get.username;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.BaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_PET_TEMPLATE;

public class PositiveGetIdTest extends BaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(PET, pet);
    }

    @Test
    public static void getPetByIdPositive() {
        Response response = Requests.get(PET_STRICT + pet.getId());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't get pet by id");
        JsonValidator.validateObject(response, PATH_TO_PET_TEMPLATE);
    }
}
