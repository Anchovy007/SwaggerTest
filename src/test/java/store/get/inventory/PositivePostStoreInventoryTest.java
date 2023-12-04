package store.get.inventory;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_INVENTORY;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_STORE_TEMPLATE;

public class PositivePostStoreInventoryTest extends StoreBaseTest {

    @BeforeClass
    public void beforeDeleteStoreByIDTests() {
        Requests.post(STORE_ORDER, store);
    }

    @Test
    public static void getStoreByIdPositive() {
        Response response = Requests.get(STORE_INVENTORY);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't get pet by id");
        JsonValidator.validateObject(response, PATH_TO_STORE_TEMPLATE);
    }
}
