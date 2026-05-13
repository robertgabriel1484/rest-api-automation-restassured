package com.robertgabriel.api.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public final class SpecFactory {
    private SpecFactory() {}

    public static RequestSpecification defaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.baseUrl())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification okResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(ApiConfig.maxResponseTimeMs()))
                .build();
    }

    public static ResponseSpecification createdResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(ApiConfig.maxResponseTimeMs()))
                .build();
    }
}
