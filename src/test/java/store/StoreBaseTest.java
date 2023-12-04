package store;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import petstore.common.create.StoreCreate;
import petstore.models.Store;
import petstore.swagger.requests.Requests;

import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class StoreBaseTest {

    public static final Store store = StoreCreate.storeCreate();

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    void tearDown() {
        Requests.delete( PET_STRICT + store.getId());
    }
}
