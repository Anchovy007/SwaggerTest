package pet.get.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import data_providers.DataProvider;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.PETS_BY_STATUS;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_PETLIST_TEMPLATE;

public class PositiveGetStatusTest {

    @Test(dataProvider = "Correct_statuses", dataProviderClass = DataProvider.class)
    public void getPetByStatusCorrectStatuses(String[] status) {
        Response response = Requests.get(PETS_BY_STATUS+status[0]);
        Assert.assertEquals(response.getStatusCode(), SC_OK);
        JsonValidator.validateList(response.toString(), PATH_TO_PETLIST_TEMPLATE);
    }

    @Test(dataProvider = "Correct_statuses", dataProviderClass = DataProvider.class)
    public void responseBodyHasStatusAccordingRequest(String[] status) throws JsonProcessingException {
        Response response = Requests.get(PETS_BY_STATUS+status[0]);
        JsonMapper mapper = new JsonMapper();
        List<Pet> myObjects = mapper.readValue(response.asString(), new TypeReference<>(){});
        for (Pet pet : myObjects) {
            Assert.assertEquals(pet.getStatus().toString(), status[0], "One of objects has incorrect parameters");
        }
    }
}
