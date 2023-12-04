package store.get.order;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data_providers.DataProvider;
import petstore.common.create.StoreCreate;
import petstore.models.Store;
import petstore.swagger.requests.Requests;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER_STRICT;

public class NegativePostStoreOrderIdTest extends StoreBaseTest {

    @BeforeClass
    public void beforeDeleteStoreByIDTests() {
        Requests.post(STORE_ORDER, store);
        Requests.delete( STORE_ORDER_STRICT + store.getId());
    }

    @Test
    public static void getStoreByNotExistingIdNegative() {
        Response response = Requests.get(STORE_ORDER_STRICT + store.getId());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Not existing pet exists");
    }

    @Test(dataProvider = "Incorrect_id", dataProviderClass = DataProvider.class)
    public static void getStoreByIncorrectIdNegative(String id) {
        Response response = Requests.get(STORE_ORDER_STRICT + id);
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Incompatible type of id works out");
    }
}
