package com.frolov.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests extends TestBase {

    Api api = new Api();

    @Test
    public void addItem() {
        Integer itemsCountBeforeAdding = api.getItemsCount();
        api.addItemToCart();
        assertEquals(api.getItemsCount(), itemsCountBeforeAdding + 1);
    }
}
