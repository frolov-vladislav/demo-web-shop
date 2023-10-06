package com.frolov.tests;

import com.codeborne.selenide.Configuration;
import config.Config;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    @BeforeAll
    static void up() {
        RestAssured.baseURI = Config.config.apiUrl();
        Configuration.baseUrl = Config.config.webUrl();
    }
}
