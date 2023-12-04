package store.post;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.common.create.StoreCreate;
import petstore.models.Store;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_STORE_TEMPLATE;

public class PositivePostStoreTest extends StoreBaseTest {

    @Test
    public void postNewStoreWithAllFieldsPositive() {
        Store store = StoreCreate.storeCreate();
        Response response = Requests.post(STORE_ORDER, store);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Store creation failed");
        JsonValidator.validateObject(response, PATH_TO_STORE_TEMPLATE);
    }
}
