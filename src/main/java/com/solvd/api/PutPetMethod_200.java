package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/pet",methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/pet/_put/put_pet_request.json")
@ResponseTemplatePath(path = "api/pet/_put/put_pet_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutPetMethod_200 extends AbstractApiMethodV2 {
    public PutPetMethod_200() {
    //    replaceUrlPlaceholder("petId",String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
