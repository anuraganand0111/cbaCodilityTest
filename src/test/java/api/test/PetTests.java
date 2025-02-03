package src.test.java.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import src.test.java.api.endpoints.PetEndpoints;
import src.test.java.api.payload.Category;
import src.test.java.api.payload.Pet;
import src.test.java.api.payload.Status;
import src.test.java.api.payload.Tag;

import java.util.Collections;
import java.util.Random;

public class PetTests {

//    Faker faker;
    Random random = new Random();
    private static final String PHOTO_URL = "https://sl.bing.net/b3mddNc3HtA";
    public static Pet petPayload;


    @BeforeTest
    public void setUpData(){
        PetEndpoints petEndpoints;
         petPayload = new Pet.Builder()
                .withId(123)
                .withName("My pet")
                .withPhotoUrls(Collections.singletonList(PHOTO_URL))
                .withStatus(Status.available)
                .withTags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .inCategory(new Category(1, "dogs")).build();


    }

    @Test(priority = 1)
    public void testPostPet(){
        Response response = PetEndpoints.postPet(petPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void testPutPet(){
        petPayload.setName("New name for my pet");
        petPayload.setStatus(Status.pending);
        Response response = PetEndpoints.postPet(petPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testPostPetById(){
        Response response = PetEndpoints.postPetById(petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void testGetPetById(){
        Response response = PetEndpoints.getPetById(petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 5)
    public void testGetPetByStatus(){
        Response response = PetEndpoints.getPetByStatus(petPayload.getStatus());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 6)
    public void testDeletePetById(){
        Response response = PetEndpoints.deletePetById(petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void testPetUploadImageById(){
        Response response = PetEndpoints.postPetUploadImageById(petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
