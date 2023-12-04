package user.post.user;

import data_providers.DataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.BaseTests;

import static org.apache.http.HttpStatus.SC_NOT_ACCEPTABLE;
import static petstore.swagger.instances.endpoints.PetEndpoints.PET_STRICT;
import static petstore.swagger.instances.endpoints.PetEndpoints.UPLOAD_IMAGE;

public class NegativeImagePostTest extends BaseTests {

    //TODO: Сайт должен работать только с картинками а работает со всеми форматами
    @Test(dataProvider = "Path_to_files_to_add_images", dataProviderClass = DataProvider.class)
    public static void postPetImageNegative(String path) {
        Response response = Requests.post(PET_STRICT + pet.getId() + UPLOAD_IMAGE, path);
        Assert.assertEquals(response.getStatusCode(), SC_NOT_ACCEPTABLE, "Incompatible type of file has been uploaded");
    }
}
