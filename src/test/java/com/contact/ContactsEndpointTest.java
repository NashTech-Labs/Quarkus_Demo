package com.contact;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ContactsEndpointTest {

    @Test
    public void getContacts() {
        given().when()
                .get("/api/contacts")
                .then()
                .statusCode(200);
                //.body(is("[{\"companyName\":\"Werner GmbH\",\"contactId\":-2,\"firstName\":\"Eva\",\"lastName\":\"Günzelsen\"},{\"companyName\":\"Bimbam AG\",\"contactId\":-1,\"firstName\":\"Egon\",\"lastName\":\"Meier\"}]"));
    }

    @Test
    public void addContact() {
        given().when()
                .contentType(ContentType.JSON)
                .body("{\"companyName\":\"Knoldus\",\"firstName\":\"Karan\",\"lastName\":\"Gupta\"}")
                .post("/api/contacts")
                .then()
                .statusCode(200)
                .body(is("{\"companyName\":\"Knoldus\",\"contactId\":1,\"firstName\":\"Karan\",\"lastName\":\"Gupta\"}"));
    }

    @Test
    public void updateContact() {
        given().when()
                .contentType(ContentType.JSON)
                .body("{\"companyName\":\"Samsung\",\"contactId\":-2,\"firstName\":\"Ajay\",\"lastName\":\"Kumar\"}")
                .put("/api/contacts/-2")
                .then()
                .statusCode(204);
    }

    @Test
    public void deleteContact() {
        given()
                .when().delete("/api/contacts/-1")
                .then()
                .statusCode(204);
    }

}