package user;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import petstore.common.create.UserCreate;
import petstore.models.User;
import petstore.swagger.requests.Requests;

import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;

public class UserBaseTests {

    public static final User user = UserCreate.userCreate();

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    void tearDown() {
        Requests.delete( PET_STRICT + user.getId());
    }
}
