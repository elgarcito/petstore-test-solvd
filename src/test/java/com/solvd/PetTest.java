package com.solvd;

import com.solvd.api.GetPetById;
import com.solvd.api.PostPetMethod;
import com.solvd.api.domain.Pet;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
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
}
