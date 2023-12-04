package petstore.common.create;

import petstore.common.generator.Generator;
import petstore.models.Category;
import petstore.models.Pet;
import petstore.models.Status;
import petstore.models.Tag;

import java.util.List;
import java.util.Random;

import static petstore.common.generator.Generator.getRandomString;

public class PetCreate {

    public static Pet createPet() {
        Category category = new Category();
        category.setId(300);
        category.setName(getRandomString(5));

        Tag tag = new Tag();
        tag.setId(41456);
        tag.setName(getRandomString(5));

        Pet pet = new Pet();
        pet.setCategory(category);
        pet.setId(new Random().nextInt(1000));
        pet.setName(getRandomString(7));
        List<String> urls = List.of(getRandomString(15));
        pet.setPhotoUrls(urls);
        pet.setTags(List.of(tag));
        pet.setStatus(Status.available);

        return pet;
    }

    public static Pet minPet() {
        Pet pet = new Pet();
        pet.setName(Generator.getRandomString(5));
        List<String> urls = List.of(Generator.getRandomString(15));
        pet.setPhotoUrls(urls);
        return pet;
    }
}
