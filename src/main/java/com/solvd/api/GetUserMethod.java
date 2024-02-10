package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/user/${username}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/user/_gets/get_user_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserMethod extends AbstractApiMethodV2 {

    public GetUserMethod(String username) {
        replaceUrlPlaceholder("username", username);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
