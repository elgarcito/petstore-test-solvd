package com.solvd;

import com.solvd.api.DeletePetById_200;
import com.solvd.api.GetPetById;
import com.solvd.api.PostPetMethod;
import com.solvd.api.PutPetMethod_200;
import com.solvd.api.domain.Pet;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetTest_200 extends AbstractTest {

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

    @Test(description = "PUT method test",priority = 3)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "PUT data",value = "api")
    public void putPet_200(){
        PutPetMethod_200 putPetMethod200=new PutPetMethod_200();
        putPetMethod200.setProperties("api/pet/_put/put_pet_200.properties");
        putPetMethod200.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPetMethod200.callAPI();
        putPetMethod200.validateResponseAgainstSchema("api/pet/_put/put_response.schema");
    }

    @Test(description = "Delete method test",priority = 4)
    @MethodOwner(owner = "Edgar")
    @TestLabel(name = "DELETE data",value = "api")
    public void deletePet_200(){
        DeletePetById_200 deletePetById200=new DeletePetById_200(230);
        deletePetById200.setProperties("api/pet/_posts/pet_200.properties");
        deletePetById200.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePetById200.callAPI();
        deletePetById200.validateResponseAgainstSchema("api/pet/_deletes/delete_response.schema");
        //Wrong response example
        SoftAssert softAssert =new SoftAssert();
        DeletePetById_200 deletePetById200_1=new DeletePetById_200(205);
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
