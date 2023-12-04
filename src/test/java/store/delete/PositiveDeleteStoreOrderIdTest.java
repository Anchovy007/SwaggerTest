package store.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import store.StoreBaseTest;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER;
import static petstore.swagger.instances.endpoints.StoreEndpoint.STORE_ORDER_STRICT;

public class PositiveDeleteStoreOrderIdTest extends StoreBaseTest {

    @BeforeClass
    public void beforeDeleteStoreByIDTests() {
        Requests.post(STORE_ORDER, store);
    }

    @Test
    public static void deleteStoreByIdPositiveTest() {
        Response response = Requests.delete( STORE_ORDER_STRICT + store.getId());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't delete existing store by id");
    }
}
