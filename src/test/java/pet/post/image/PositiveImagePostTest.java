package pet.post.image;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pet.BaseTests;
import petstore.swagger.requests.Requests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.PetEndpoints.*;
import static petstore.swagger.instances.file_paths.Paths.IMAGE_FILE_PATH;

public class PositiveImagePostTest extends BaseTests {

    @Test
    public static void postPetImagePositive() {
        Response response = Requests.post(PET_STRICT + pet.getId() + UPLOAD_IMAGE,
              IMAGE_FILE_PATH);
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Image doesn't upload to server");
    }
}
