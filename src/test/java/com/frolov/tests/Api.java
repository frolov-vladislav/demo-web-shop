package com.frolov.tests;

import config.Config;

import static io.qameta.allure.Allure.step;
import static filters.CustomLogs.customLogs;
import static io.restassured.RestAssured.given;

public class Api {

    private static String cookie;

    public static void getCookie() {
        String email = Config.config.userEmail();
        String password = Config.config.userPassword();

        cookie = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", email)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .extract().cookie("NOPCOMMERCE.AUTH");
    }

    public int getItemsCount() {
        return step("Get items count in cart", () -> Integer.parseInt(given()
                .filter(customLogs().customTemplates())
                .cookie("NOPCOMMERCE.AUTH", cookie)
                .get("/cart")
                .then()
                .log().status()
                .extract().htmlPath().getString("html.body.div[3].div[0].div[0].div[1].div[0].ul.li[2].a.span[1]").replaceAll("\\D", "")));
    }

    public void addItemToCart() {
        step("Add item to card", () -> {
            given()
                    .filter(customLogs().customTemplates())
                    .cookie("NOPCOMMERCE.AUTH", cookie)
                    .contentType("application/json; charset=utf-8")
                    .post("/addproducttocart/catalog/31/1/1")
                    .then()
                    .log().body();
        });
    }
}