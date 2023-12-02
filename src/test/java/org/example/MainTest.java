package org.example;

import org.example.models.MobileData;
import org.example.models.TopNavigationData;
import org.example.steps.SchemaFilterSteps;
import org.example.steps.SchemaProductSteps;
import org.example.steps.TopNavigationSteps;
import org.example.utils.JsonReader;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    SchemaFilterSteps schemaFilterSteps = new SchemaFilterSteps();
    SchemaProductSteps schemaProductSteps = new SchemaProductSteps();
    Utils utils = new Utils();

    @Test(description = "Move around the catalog",
            dataProvider = "topNavigationData", dataProviderClass = JsonReader.class)
    public void moveAroundCatalog(TopNavigationData topNavigationData) {
        navigationSteps.clickTopMenuItem(topNavigationData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(topNavigationData.getClassifierItemName());
        navigationSteps.clickAsideListItem(topNavigationData.getClassifierItemName(),
                topNavigationData.getAsideItemName());
        navigationSteps.clickDropDownItem(topNavigationData.getClassifierItemName(), topNavigationData.getAsideItemName(),
                topNavigationData.getDropDownItemName());

        String actual = schemaFilterSteps.extractTextFromSchemaHeader();
        Assert.assertEquals(actual, topNavigationData.getSchemaHeaderText());
    }

    @Test(description = "Sorting phones by price, manufacturer, shop, release date",
            dataProvider = "mobileData", dataProviderClass = JsonReader.class)
    public void chooseMobile(MobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(),
                mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelShop(), mobileData.getShopName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelDate(), mobileData.getReleaseDate());

        int actual = schemaFilterSteps.getNumberFromSchemaFilterButton();
        Assert.assertEquals(actual, mobileData.getNumberOfPhones());
    }

    @Test(description = "Choose the cheapest mobile phone",
            dataProvider = "mobileData", dataProviderClass = JsonReader.class)
    public void chooseTheCheapestMobile(MobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(),
                mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelShop(), mobileData.getShopName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelDate(), mobileData.getReleaseDate());
        schemaProductSteps.clickTheCheapestProduct();

        double actual = schemaProductSteps.getOffersDescriptionPrice();
        Assert.assertEquals(actual, mobileData.getPriceOfTheCheapestMobile());
    }
}
