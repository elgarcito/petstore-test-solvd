package com.solvd;

import com.solvd.api.DeletePetMethod;
import com.solvd.api.GetPetById;
import com.solvd.api.PostPetMethod;
import com.solvd.api.PutPetMethod;
import com.solvd.api.domain.Pet;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class PetTest {
    @Test(description = "Verify post pet with valid data")
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
    public void verifyValidPutByIdTest() {
        PutPetMethod putPetMethod = new PutPetMethod();
        putPetMethod.setProperties("api/pet/pet.properties");

        putPetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPetMethod.callAPI();

        //create autenticate
        JsonComparatorContext comparatorContext = JsonComparatorContext.context();
        putPetMethod.validateResponse(comparatorContext);

    }
}
