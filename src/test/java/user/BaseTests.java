package user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
