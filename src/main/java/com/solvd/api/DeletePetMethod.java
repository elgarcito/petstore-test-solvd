package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/pet/${petId}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/pet/_deletes/delete_pet_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeletePetMethod extends AbstractApiMethodV2 {
    public DeletePetMethod(Integer id) {
        replaceUrlPlaceholder("petId", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class); //Always write this
    }

}
