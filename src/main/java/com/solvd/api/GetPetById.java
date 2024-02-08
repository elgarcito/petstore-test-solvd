package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/pet/${petId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/pet/get_pet_by_id_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPetById extends AbstractApiMethodV2 {
    public GetPetById(Integer id) {
        replaceUrlPlaceholder("petId", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class); //Always write this
    }
}
