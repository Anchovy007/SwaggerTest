package store.get.order;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_OK;

import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_STORE_TEMPLATE;

public class PositivePostStoreOrderIdTest extends StoreBaseTest {

    @BeforeClass
    public void beforeDeleteStoreByIDTests() {
        Requests.post(STORE_ORDER, store);
    }

    @Test
    public static void getStoreByIdPositive() {
        Response response = Requests.get(PET_STRICT + store.getId());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't get pet by id");
        JsonValidator.validateObject(response, PATH_TO_STORE_TEMPLATE);
    }
}
