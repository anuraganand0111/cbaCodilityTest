package src.test.java.api.endpoints;

/* Swagger Urls
 BasUrl--Base URL: petstore.swagger.io/v2
 POST petImage : /pet/{petId}/uploadImage
 POST pet : /pet
 PUT pet : /pet
 GET petFindByStatus: /pet/findByStatus
 GET getPetByPetId: /pet/{petId}
 POST postByPetId: /pet/{petId}
 DELETE deleteByPetId: /pet/{petId}


 */
public class Routes {
    public static String baseUrl ="https://petstore.swagger.io/v2";

    //Pet Module Endpoints
    public static String postPetImageURL = baseUrl + "/pet/{petId}/uploadImage";
    public static String postPetURL = baseUrl + "/pet";
    public static String putPetUrl = baseUrl + "/pet";
    public static String getPetByStatusUrl = baseUrl + "/pet/findByStatus";
    public static String getPetByIdUrl = baseUrl + "/pet/{petId}";
    public static String postPetByIdUrl = baseUrl + "/pet/{petId}";
    public static String deletePetByIdUrl = baseUrl + "/pet/{petId}";

}
