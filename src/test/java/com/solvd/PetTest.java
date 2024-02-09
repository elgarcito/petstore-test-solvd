package com.solvd;

import com.solvd.api.DeletePetMethod;
import com.solvd.api.GetPetById;
import com.solvd.api.PostPetMethod;
import com.solvd.api.PutPetMethod;
import com.solvd.api.domain.Pet;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetTest implements IAbstractTest {
    @Test(description = "Verify post pet with valid data")
    @MethodOwner(owner = "Carolina")
    public void verifyValidPostPetTest() {
        PostPetMethod postPetMethod = new PostPetMethod();
        postPetMethod.setProperties("api/pet/pet.properties");

        postPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postPetMethod.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postPetMethod.validateResponse(comparatorContext);

    }

    @Test(description = "Verify get pet with valid data")
    @MethodOwner(owner = "Carolina")
    public void verifyValidGetPetByIdTest() {
        Pet pet = new Pet();
        pet.setPetId(100);

        GetPetById getPetById = new GetPetById(pet.getPetId());
        getPetById.addProperty("pet", pet);

        getPetById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPetById.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getPetById.validateResponse(comparatorContext);
    }

    @Test(description = "Verify post pet with invalid data")
    @MethodOwner(owner = "Carolina")
    public void verifyInvalidGetPetByIdTest() {
        Pet petInvalid = new Pet();
        petInvalid.setPetId(-1);

        GetPetById getPetById = new GetPetById(petInvalid.getPetId());
        getPetById.addProperty("pet", petInvalid);
        getPetById.setResponseTemplate("api/pet/_deletes/delete_pet_response.json");

        getPetById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getPetById.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        getPetById.validateResponse(comparatorContext);
    }

    @Test(description = "Verify get pet with valid data")
    @MethodOwner(owner = "Carolina")
    public void verifyValidDeletePetByIdTest() {
        Pet pet = new Pet();
        pet.setPetId(1);

        DeletePetMethod deletePetMethod = new DeletePetMethod(pet.getPetId());
        deletePetMethod.addProperty("pet", pet);

        deletePetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePetMethod.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        deletePetMethod.validateResponse(comparatorContext);
    }
    @Test(description = "Verify put pet with valid data")
    @MethodOwner(owner = "Carolina")
    public void verifyValidPutByIdTest() {
        PutPetMethod putPetMethod = new PutPetMethod();
        putPetMethod.setProperties("api/pet/pet.properties");

        putPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPetMethod.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        putPetMethod.validateResponse(comparatorContext);

    }


    @Test(description = "Get pet from id 200 valid assertion" ,priority = 2)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "GET data",value = "api")
    public void getPetById_200(){
        Pet myPet=new Pet();
        myPet.setPetId(230);
        GetPetById getPetById =new GetPetById(myPet.getPetId());
        getPetById.addProperty("pet",myPet);
        getPetById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPetById.callAPI();
        getPetById.validateResponseAgainstSchema("api/pet/_gets/get_response.schema");
        //Wrong response example
        Pet myPet2=new Pet();
        myPet2.setPetId(205);
        GetPetById getPetById_2 =new GetPetById(myPet2.getPetId());
        getPetById_2.addProperty("pet",myPet2);
        SoftAssert softAssert=new SoftAssert();
        HttpResponseStatusType expectedStatus =HttpResponseStatusType.OK_200;
        Response response= getPetById_2.callAPI();
        HttpResponseStatusType responseStatusType=toHttpResponseStatusType(response.getStatusCode());
        softAssert.assertEquals(responseStatusType,expectedStatus,"Response not expected");
        softAssert.assertAll();
    }

    @Test(description = "Post method test",priority = 1)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "POST data",value = "api")
    public void postPet_200(){
        PostPetMethod postPetMethod=new PostPetMethod();
        postPetMethod.setProperties("api/pet/_posts/pet_200.properties");
        postPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postPetMethod.callAPI();
        postPetMethod.validateResponseAgainstSchema("api/pet/_gets/get_response.schema");
    }

    @Test(description = "PUT method test from id 200",priority = 3)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "PUT data",value = "api")
    public void putPet_200(){
        PutPetMethod putPetMethod200=new PutPetMethod();
        putPetMethod200.setProperties("api/pet/_put/put_pet_200.properties");
        putPetMethod200.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPetMethod200.callAPI();
        putPetMethod200.validateResponseAgainstSchema("api/pet/_put/put_response.schema");
    }

    @Test(description = "Delete method test from id 200",priority = 4)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "DELETE data",value = "api")
    public void deletePet_200(){
        DeletePetMethod deletePetById200=new DeletePetMethod(230);
        deletePetById200.setProperties("api/pet/_posts/pet_200.properties");
        deletePetById200.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePetById200.callAPI();
        deletePetById200.validateResponseAgainstSchema("api/pet/_deletes/delete_response.schema");
        //Wrong response example
        SoftAssert softAssert =new SoftAssert();
        DeletePetMethod deletePetById200_1=new DeletePetMethod(205);
        Response response= deletePetById200_1.callAPI();
        HttpResponseStatusType responseStatusType=toHttpResponseStatusType(response.getStatusCode());
        softAssert.assertEquals(responseStatusType,HttpResponseStatusType.OK_200,"Response not expected");
        softAssert.assertAll();
        deletePetById200_1.validateResponseAgainstSchema("api/pet/_deletes/delete_response.schema");
    }
    public HttpResponseStatusType toHttpResponseStatusType(int statusCode) {
        switch (statusCode) {
            case 200:
                return HttpResponseStatusType.OK_200;
            case 201:
                return HttpResponseStatusType.CREATED_201;
            case 202:
                return HttpResponseStatusType.ACCEPTED_202;
            case 404:
                return HttpResponseStatusType.NOT_FOUND_404;
            default:
                throw new IllegalArgumentException("Código de estado HTTP no soportado: " + statusCode);
        }
    }
}
