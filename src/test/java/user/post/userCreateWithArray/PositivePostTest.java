package user.post.userCreateWithArray;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.common.create.PetCreate;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.BaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_PET_TEMPLATE;

public class PositivePostTest extends BaseTests {

    @Test
    public void postNewPetWithAllFieldsPositive() {
        Response response = Requests.post(PET, pet);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Pet creation failed");
        JsonValidator.validateObject(response, PATH_TO_PET_TEMPLATE);
    }

    @Test
    public static void postNewPetWithRequiredFieldsPositive() {
        Pet pet = PetCreate.minPet();
        Response response = Requests.post(PET, pet);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Pet creation failed");
        JsonValidator.validateObject(response, PATH_TO_PET_TEMPLATE);
    }
}

