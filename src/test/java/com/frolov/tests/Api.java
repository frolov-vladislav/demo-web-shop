package com.frolov.tests;

import config.Config;

import static io.restassured.RestAssured.given;

public class Api {

    static String email,
            password;

    public String getCookie() {
        email = Config.config.userEmail();
        password = Config.config.userPassword();

        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", email)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract().cookie("NOPCOMMERCE.AUTH");
    }

    public Integer getItemsCount() {
        return Integer.parseInt(given()
                .cookie("NOPCOMMERCE.AUTH", getCookie())
                .get("/cart")
                .then()
                .extract().htmlPath().getString("html.body.div[3].div[0].div[0].div[1].div[0].ul.li[2].a.span[1]").replaceAll("\\D", ""));
    }

    public void addItemToCart() {
        given()
                .cookie("NOPCOMMERCE.AUTH", getCookie())
                .contentType("application/json; charset=utf-8")
                .post("/addproducttocart/catalog/31/1/1")
                .then()
                .statusCode(200);
    }
}