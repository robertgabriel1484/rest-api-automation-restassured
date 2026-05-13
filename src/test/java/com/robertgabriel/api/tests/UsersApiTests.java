package com.robertgabriel.api.tests;

import com.robertgabriel.api.core.SpecFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTests {

    @Test
    public void getUsersReturnsValidUserRecords() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
        .when()
                .get("/users")
        .then()
                .spec(SpecFactory.okResponseSpec())
                .body("size()", equalTo(10))
                .body("[0].id", equalTo(1))
                .body("[0].email", containsString("@"))
                .body("[0].address.city", not(emptyOrNullString()))
                .body("[0].company.name", not(emptyOrNullString()));
    }

    @Test
    public void getUserByIdReturnsNestedAddressAndCompanyData() {
        given()
                .spec(SpecFactory.defaultRequestSpec())
                .pathParam("userId", 1)
        .when()
                .get("/users/{userId}")
        .then()
                .spec(SpecFactory.okResponseSpec())
                .body("id", equalTo(1))
                .body("username", not(emptyOrNullString()))
                .body("address.geo.lat", notNullValue())
                .body("address.geo.lng", notNullValue())
                .body("company.catchPhrase", not(emptyOrNullString()));
    }
}
