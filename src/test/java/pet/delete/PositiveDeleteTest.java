package pet.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pet.BaseTests;
import petstore.swagger.requests.Requests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class PositiveDeleteTest extends BaseTests {

    @BeforeClass
    public void beforeDeletePetByIDTests() {
        Requests.post(PET, pet);
    }

    @Test
    public static void deletePetByIdPositiveTest() {
        Response response = Requests.delete( PET_STRICT + pet.getId());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't delete existing pet by id");
    }

}
