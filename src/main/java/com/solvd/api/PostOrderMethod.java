package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/store/order", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/store/_posts/post_order_request.json")
@ResponseTemplatePath(path = "api/store/_gets/get_order_by_id_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostOrderMethod extends AbstractApiMethodV2 {
    public PostOrderMethod(){
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
