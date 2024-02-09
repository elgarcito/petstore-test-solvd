package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/store/order/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/pet/_gets/get_pet_by_id_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetOrderMethod extends AbstractApiMethodV2 {
    public GetOrderMethod(Integer id){
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
