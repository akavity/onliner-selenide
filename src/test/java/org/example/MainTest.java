package org.example;

import org.example.models.MobileData;
import org.example.models.TopNavigationData;
import org.example.steps.ShoppingSteps;
import org.example.steps.TopNavigationSteps;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    ShoppingSteps shoppingSteps = new ShoppingSteps();

    @Test(description = "Move around the catalog",
            dataProvider = "topNavigationData", dataProviderClass = JsonReader.class)
    public void moveAroundCatalog(TopNavigationData topNavigationData) {
        navigationSteps.clickTopMenuItem(topNavigationData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(topNavigationData.getClassifierItemName());
        navigationSteps.clickAsideListItem(topNavigationData.getClassifierItemName(),
                topNavigationData.getAsideItemName());
        navigationSteps.clickDropDownItem(topNavigationData.getClassifierItemName(), topNavigationData.getAsideItemName(),
                topNavigationData.getDropDownItemName());

        String actual = shoppingSteps.extractTextFromSchemaHeader();
        Assert.assertEquals(actual, topNavigationData.getSchemaHeaderText());
    }

    @Test(description = "Sorting phones by price, manufacturer, shop",
            dataProvider = "mobileData", dataProviderClass = JsonReader.class)
    public void chooseMobile(MobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(),
                mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        shoppingSteps.clickSchemaFilterCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        shoppingSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        shoppingSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        shoppingSteps.clickSchemaFilterCheckboxItem(mobileData.getLabelShop(), mobileData.getShopName());
        shoppingSteps.clickSchemaFilterCheckboxItem(mobileData.getLabelDate(), mobileData.getReleaseDate());

        int actual = shoppingSteps.getNumberFromSchemaFilterButton();
        Assert.assertEquals(actual, mobileData.getNumberOfPhones());
    }
}
