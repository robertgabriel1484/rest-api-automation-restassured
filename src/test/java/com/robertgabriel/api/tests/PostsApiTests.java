package com.robertgabriel.api.tests;

import com.robertgabriel.api.core.SpecFactory;
import com.robertgabriel.api.models.PostPayload;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsApiTests {

    @Test
    public void getAllPostsReturnsExpectedCollection() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
        .when()
                .get("/posts")
        .then()
                .spec(SpecFactory.okResponseSpec())
                .body("size()", greaterThan(0))
                .body("[0].userId", notNullValue())
                .body("[0].id", notNullValue())
                .body("[0].title", not(emptyOrNullString()))
                .body("[0].body", not(emptyOrNullString()));
    }

    @Test
    public void getPostByIdReturnsExpectedFields() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
                .pathParam("postId", 1)
        .when()
                .get("/posts/{postId}")
        .then()
                .spec(SpecFactory.okResponseSpec())
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", not(emptyOrNullString()))
                .body("body", not(emptyOrNullString()));
    }

    @Test
    public void postResponseMatchesJsonSchema() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
                .pathParam("postId", 1)
        .when()
                .get("/posts/{postId}")
        .then()
                .spec(SpecFactory.okResponseSpec())
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/test/resources/schemas/post-schema.json")));
    }

    @Test
    public void createPostReturnsCreatedPayload() {
        PostPayload payload = new PostPayload(
                10,
                "QA automation portfolio post",
                "Testing POST behavior with REST-Assured"
        );

        given()
                .spec(SpecFactory.defaultRequestSpec())
                .body(payload)
        .when()
                .post("/posts")
        .then()
                .spec(SpecFactory.createdResponseSpec())
                .body("userId", equalTo(10))
                .body("title", equalTo("QA automation portfolio post"))
                .body("body", equalTo("Testing POST behavior with REST-Assured"))
                .body("id", notNullValue());
    }

    @Test
    public void missingPostReturnsNotFound() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
                .pathParam("postId", 999999)
        .when()
                .get("/posts/{postId}")
        .then()
                .statusCode(404);
    }
}
