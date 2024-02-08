package com.solvd;

import com.solvd.api.GetOrderMethod;
import com.solvd.api.PostOrderMethod;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class StoreTest {

    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Post a order in the store", priority = 1)
    public void verifyPostStore(){
        PostOrderMethod postOrderMethod = new PostOrderMethod();
        postOrderMethod.setProperties("api/store/_posts/post_order.properties");

        postOrderMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postOrderMethod.callAPI();


        postOrderMethod.validateResponseAgainstSchema("api/store/_posts/post_order.schema");
    }

    @MethodOwner(owner = "Pablo Rizzieri")
    @Test(description = "Get a Store by id", priority = 2)
    public void verifyOrderById(){
        GetOrderMethod getOrderMethod = new GetOrderMethod(32);
        getOrderMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getOrderMethod.callAPI();
        getOrderMethod.validateResponseAgainstSchema("api/store/_gets/get_order_by_id.schema");
    }

}
