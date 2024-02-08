package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/pet", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/pet/_puts/put_pet_response.json")
@RequestTemplatePath(path = "api/pet/_puts/put_pet_request.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutPetMethod extends AbstractApiMethodV2 {
    public PutPetMethod(){
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
