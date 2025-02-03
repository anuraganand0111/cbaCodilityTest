package src.test.java.api.endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import src.test.java.api.payload.Pet;
import src.test.java.api.payload.Status;

import java.io.File;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

//creted for performing crud operation on pet api
public class PetEndpoints {

//    private static final String PHOT_URL_UPDATED = "https://sl.bing.net/heIDD4mVDJk";
    // Path to the image file
static File imageFile = new File("src/test/java/api/utilities/petImage.jpeg");

    public static Response postPet(Pet payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postPetURL);

        return response;

    }

    public static Response putPet(Pet payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.putPetUrl);

        return response;

    }

    public static Response postPetById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .formParam("name", "Labrador")
                .formParam("status", Status.pending)
                .when()
                .post(Routes.postPetByIdUrl);

        return response;

    }

    public static Response getPetById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .post(Routes.getPetByIdUrl);

        return response;

    }


    public static Response deletePetById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .post(Routes.deletePetByIdUrl);

        return response;

    }

    public static Response getPetByStatus(Status status) {
        // Define the endpoint and parameters
        Response response = given()
                .queryParam("status", Status.available)
                .when()
                .get(Routes.getPetByStatusUrl);

        return response;
    }

    public static Response postPetUploadImageById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .formParam("additional Info", "Labrador")
                .multiPart(imageFile)
                .when()
                .post(Routes.postPetImageURL);

        return response;

    }

}
