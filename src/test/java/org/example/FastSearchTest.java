package org.example;

import org.example.steps.CartSteps;
import org.example.steps.ProductSteps;
import org.example.steps.TopActionsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FastSearchTest extends BaseTest {
    TopActionsSteps topActionsSteps = new TopActionsSteps();
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test
    public void addProductInCart() {
        topActionsSteps.enterProductName("HONOR Pad X8 LTE");
        topActionsSteps.clickFirstProduct();
        productSteps.addToCart();
        productSteps.clickRecommendedCartButton();

        String actual = cartSteps.extractTextFromProductTitle();
        Assert.assertTrue(actual.contains("HONOR Pad X8 LTE"));
    }
}
