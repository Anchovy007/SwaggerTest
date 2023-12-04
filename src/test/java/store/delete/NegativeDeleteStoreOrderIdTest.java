package store.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data_providers.DataProvider;
import petstore.swagger.requests.Requests;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER_STRICT;

public class NegativeDeleteStoreOrderIdTest extends StoreBaseTest {

    @BeforeClass
    public void beforeDeleteStoreByIDTests() {
        Requests.post(STORE_ORDER, store);
        Requests.delete( STORE_ORDER_STRICT + store.getId());
    }

    @Test(dataProvider = "Incorrect_id", dataProviderClass = DataProvider.class)
    public static void deleteStoreByIncorrectIdNegative(String id) {
        Response response = Requests.delete(STORE_ORDER_STRICT + id);
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Incompatible type of id works out");
    }

    @Test
    public static void deleteNotExistingStoreByIdNegativeTest() {
        Response response = Requests.delete( STORE_ORDER_STRICT + store.getId());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Delete not existing pet has done successfully");
    }

    @Test
    public static void sendDeleteRequestWithEmptyQueryTest() {
        Response response = Requests.delete(STORE_ORDER_STRICT);
        Assert.assertEquals(response.getStatusCode(), SC_METHOD_NOT_ALLOWED, "Empty query doesn't invoke an error");
    }
}
