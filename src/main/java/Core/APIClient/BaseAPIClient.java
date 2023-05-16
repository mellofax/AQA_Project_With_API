package Core.APIClient;

import com.codeborne.selenide.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPIClient {
    protected RequestSpecification requestSpecification;

    protected BaseAPIClient(String baseURL) {
        var uri = baseURL.startsWith("http") ? baseURL : Configuration.baseUrl + baseURL;
        //var token = baseURL.contains("mailinator") ? "df35b0b433e84efd8ab8220d458dbe6c" : "Bearer " + retrieveAuthToken();
        this.requestSpecification =  new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(uri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .log(LogDetail.ALL)
                .setUrlEncodingEnabled(false)
                //.addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
