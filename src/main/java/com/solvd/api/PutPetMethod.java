package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/pet", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/pet/_posts/post_pet_request.json")
@ResponseTemplatePath(path = "api/pet/_gets/get_pet_by_id_response.json")
public class PutPetMethod extends AbstractApiMethodV2 {
    public PutPetMethod() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class); //Always write this
    }
}