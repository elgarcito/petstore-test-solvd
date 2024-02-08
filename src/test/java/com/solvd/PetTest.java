package com.solvd;

import com.solvd.api.GetPetById;
import com.solvd.api.PostPetMethod;
import com.solvd.api.domain.Pet;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PetTest {
    @Test
    public void verifyValidPostPetTest() {
      /*  Pet pet = new Pet();
        pet.setName("Doggie");
        pet.setCategory("Dog");
        pet.setTags("Dog");
        pet.setPhotoUrls("");
        pet.setPetId(1);
        pet.setStatus("OK");*/

        PostPetMethod postPetMethod = new PostPetMethod();
        //postPetMethod.addProperty("pet", pet);
        postPetMethod.setProperties("api/pet/pet.properties");

        postPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postPetMethod.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postPetMethod.validateResponse(comparatorContext);

    }

    @Test
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
/*
    @Test
    public void verifyInvalidGetPetByIdTest() {
        Pet petInvalid = new Pet();
        petInvalid.setPetId(1);

        GetPetById getPetById = new GetPetById(petInvalid.getPetId());
        getPetById.addProperty("pet", petInvalid);

        getPetById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPetById.callAPI();
    }*/


    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Verifies the successful creation of a pet through a POST request.", priority = 1)
    @TestLabel(name = "Post Data", value = "API")
    public void verifyValidPostPet(){
        PostPetMethod postPetMethod = new PostPetMethod();
        postPetMethod.setProperties("api/pet/_posts/post.properties");


        postPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postPetMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        postPetMethod.validateResponse(comparatorContext);
    }

    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Verifies the successful update of a pet through a PUT request.", priority = 2)
    @TestLabel(name = "Put Data", value = "API")
    public void verifyValidPutPet(){
        PutPetMethod putPetMethod = new PutPetMethod();
        putPetMethod.setProperties("api/pet/_puts/put.properties");

        putPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPetMethod.callAPI();

        putPetMethod.validateResponseAgainstSchema("api/pet/_puts/put_pet.schema");

    }


    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Verifies the successful retrieval of a pet by its ID.", priority = 3)
    @TestLabel(name = "Get Data", value = "API")
    public void verifyValidGetPetById(){
        Pet validPet = new Pet();
        validPet.setPetId(508);

        GetPetById getPetById = new GetPetById(validPet.getPetId());
        getPetById.addProperty("pet", validPet);

        getPetById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPetById.callAPI();

        getPetById.validateResponseAgainstSchema("api/pet/_gets/get_pet_by_id.schema");
    }

    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Verifies the handling of an invalid attempt to retrieve a pet by an ID that does not exist.")
    @TestLabel(name = "Get Invalid Data", value = "API")
    public void verifyInvalidGetPetById(){
        Pet invalidPet = new Pet();
        invalidPet.setPetId(501);

        GetPetById getPetById = new GetPetById(invalidPet.getPetId());
        getPetById.addProperty("pet", invalidPet);

        getPetById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getPetById.callAPI();
    }

    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Verifies the deletion of a pet through a DELETE request.", priority = 4)
    @TestLabel(name = "Delete Data", value = "API")
    public void verifyValidPetDelete(){

        DeletePetMethod deletePetMethod = new DeletePetMethod(508);
        deletePetMethod.setProperties("api/pet/_posts/post.properties");

        deletePetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePetMethod.callAPI();

        deletePetMethod.validateResponseAgainstSchema("api/pet/_deletes/delete_by_id_response.schema");

    }
}
