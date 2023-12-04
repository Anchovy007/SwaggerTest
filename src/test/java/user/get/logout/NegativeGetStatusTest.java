package user.get.logout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import data_providers.DataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;

import java.util.List;

import static petstore.swagger.instances.endpoints.PetEndpoints.PETS_BY_STATUS;

public class NegativeGetStatusTest {

    @Test(dataProvider = "Incorrect_statuses", dataProviderClass = DataProvider.class)
    public void getPetByStatusCorrectStatuses(String[] status) throws JsonProcessingException {
        Response response = Requests.get(PETS_BY_STATUS+status[0]);
        JsonMapper mapper = new JsonMapper();
        List<Pet> myObjects = mapper.readValue(response.asString(), new TypeReference<>(){});
        Assert.assertEquals(myObjects.size(), 0, "Pet statuses list is not empty");
    }
}
