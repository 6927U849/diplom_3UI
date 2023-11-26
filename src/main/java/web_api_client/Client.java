package web_api_client;

import config.BaseConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Client {

   private final String MAIN_URL = BaseConfig.MAIN_URL;
    protected RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(MAIN_URL)
                .build();
    }
}
