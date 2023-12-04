package user.get.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import data_providers.DataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PETS_BY_STATUS;

public class PositiveGetStatusTest {

    @Test(dataProvider = "Correct_statuses", dataProviderClass = DataProvider.class)
    public void getPetByStatusCorrectStatuses(String[] status) {
        Response response = Requests.get(PETS_BY_STATUS+status[0]);
        Assert.assertEquals(response.getStatusCode(), SC_OK);
        JsonValidator.validateList(response.toString());
    }

    @Test(dataProvider = "Correct_statuses", dataProviderClass = DataProvider.class)
    public void responseBodyHasStatusAccordingRequest(String[] status) throws JsonProcessingException {
        Response response = Requests.get(PETS_BY_STATUS+status[0]);
        JsonMapper mapper = new JsonMapper();
        List<Pet> myObjects = mapper.readValue(response.asString(), new TypeReference<>(){});
        for (Pet pet : myObjects) {
            Assert.assertEquals(pet.getStatus(), status[0], "One of objects has incorrect parameters");
        }
    }
}
