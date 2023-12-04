package pet.get.id;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data_providers.DataProvider;
import pet.BaseTests;
import petstore.common.create.PetCreate;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class NegativeGetIdTest extends BaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(PET, pet);
        Requests.delete( PET_STRICT + pet.getId());
    }

    @Test
    public static void getPetByNotExistingIdNegative() {
        Response response = Requests.get(PET_STRICT + pet.getId());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Not existing pet exists");
    }

    @Test(dataProvider = "Incorrect_id", dataProviderClass = DataProvider.class)
    public static void getPetByIncorrectIdNegative(String id) {
        Response response = Requests.get(PET_STRICT + id);
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Incompatible type of id works out");
    }

}
