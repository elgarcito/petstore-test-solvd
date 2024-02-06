package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${config.api_url}/pet", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/pet/_posts/post_pet_request.json")
@ResponseTemplatePath(path = "api/pet/_gets/get_pet_by_id_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostPetMethod extends AbstractApiMethodV2 {

    public PostPetMethod() {
        //super("api/pets/_posts/post_pet_request.json", "api/pets/get_pet_by_id_response.json", "api/pets/pet.properties");
        ignorePropertiesProcessor(NotStringValuesProcessor.class); //Always write this
    }
}
