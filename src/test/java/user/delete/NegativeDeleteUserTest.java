package user.delete;

import data_providers.DataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.BaseTests;

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class NegativeDeleteUserTest extends BaseTests {

    @BeforeClass
    public void beforeDeleteNegativeTests() {
        Requests.post(PET, pet);
        Requests.delete( PET_STRICT + pet.getId());
    }

    @Test(dataProvider = "Incorrect_id", dataProviderClass = DataProvider.class)
    public static void deletePetByIncorrectIdNegative(String id) {
        Response response = Requests.delete(PET_STRICT + id);
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Incompatible type of id works out");
    }

    @Test
    public static void deleteNotExistingPetByIdNegativeTest() {
        Response response = Requests.delete( PET_STRICT + pet.getId());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Delete not existing pet has done successfully");
    }

    @Test
    public static void sendDeleteRequestWithEmptyQueryTest() {
        Response response = Requests.delete(PET_STRICT);
        Assert.assertEquals(response.getStatusCode(), SC_METHOD_NOT_ALLOWED, "Empty query doesn't invoke an error");
    }
}
