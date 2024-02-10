package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/user", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/user/_posts/post_user_request.json")
@ResponseTemplatePath(path = "api/user/_posts/post_user_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostUserMethod extends AbstractApiMethodV2 {

    public PostUserMethod() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
