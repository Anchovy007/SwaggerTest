package pet;

import org.testng.annotations.*;
import petstore.common.create.PetCreate;
import petstore.models.Pet;
import petstore.swagger.requests.Requests;

import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class BaseTests {

    public static final Pet pet = PetCreate.createPet();

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    void tearDown() {
        Requests.delete( PET_STRICT + pet.getId());
    }
}
