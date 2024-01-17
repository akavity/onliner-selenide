package org.example;

import org.example.annotations.TestData;
import org.example.models.SearchData;
import org.example.steps.CartSteps;
import org.example.steps.ProductSteps;
import org.example.steps.TopActionsSteps;
import org.example.utils.JsonReaderGson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FastSearchTest extends BaseTest {
    TopActionsSteps topActionsSteps = new TopActionsSteps();
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @TestData(jsonFile = "searchData", model = "SearchData")
    @Test(description = "Add product to cart",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void addProductToCart(SearchData searchData) {
        topActionsSteps.enterProductName(searchData.getProduct());
        topActionsSteps.clickFirstProduct();
        productSteps.closeYourCityPopUpWindow();
        productSteps.addToCart();
        productSteps.clickRecommendedCartButton();

        String actual = cartSteps.extractTextFromProductTitle();
        Assert.assertTrue(actual.contains(searchData.getProduct()));
    }
}
