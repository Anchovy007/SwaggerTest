package user.put;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.common.create.PetCreate;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.BaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_PET_TEMPLATE;

public class PositivePutTest extends BaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(PET, pet);
    }

    @Test
    public static void putNewPetInfoPositive() {
        Pet pet = PetCreate.minPet();
        Response response = Requests.put(PET, pet);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Setting new info has failed");
        JsonValidator.validateObject(response, PATH_TO_PET_TEMPLATE);
    }
}
