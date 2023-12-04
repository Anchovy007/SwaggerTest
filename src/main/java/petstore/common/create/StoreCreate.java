package petstore.common.create;

import petstore.models.Status;
import petstore.models.Store;


public class StoreCreate {

    public static Store storeCreate() {
        Store store = new Store();
        store.setId(2);
        store.setPetId(0);
        store.setQuantity(0);
        store.setShipDate("2023-12-04T10:02:17.761Z");
        store.setStatus(Status.available);
        store.setComplete(true);
        return store;
    }

}
