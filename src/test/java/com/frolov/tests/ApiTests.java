package com.frolov.tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiTests extends TestBase {

    Api api = new Api();

    @Test
    public void addItem() {
        int itemsCountBeforeAdding = api.getItemsCount();
        api.addItemToCart();
        int itemsCountAfterAdding = api.getItemsCount();
        int expectedCount = itemsCountBeforeAdding + 1;
        step(String.format("Actual item count in cart (%s) is equal to expected (%s)",
                itemsCountAfterAdding, expectedCount), () -> assertEquals(itemsCountAfterAdding, expectedCount));
    }
}
