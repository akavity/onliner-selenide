package org.example;

import org.example.annotations.TestData;
import org.example.models.MobileData;
import org.example.models.MobileDataTask2;
import org.example.models.TopNavigationData;
import org.example.steps.SchemaFilterSteps;
import org.example.steps.SchemaProductSteps;
import org.example.steps.TopNavigationSteps;
import org.example.utils.JsonReaderGson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    SchemaFilterSteps schemaFilterSteps = new SchemaFilterSteps();
    SchemaProductSteps schemaProductSteps = new SchemaProductSteps();

    @TestData(jsonFile = "mobileData", model = "MobileData")
    @Test(description = "Move around the catalog",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
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

    @TestData(jsonFile = "mobileData", model = "MobileData")
    @Test(description = "Sorting phones by price, manufacturer, shop, release date",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void sortingMobileByFilters(MobileData mobileData) {
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

    @TestData(jsonFile = "mobileDataTask2", model = "MobileDataTask2")
    @Test(description = "Sorting phones by price, manufacturer, RAM,  internal memory, memory card support",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void sortingMobileByFiltersTask2(MobileDataTask2 mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(),
                mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.setMinLimitSelector(mobileData.getLabelRAM(), mobileData.getMinRAM());
        schemaFilterSteps.setMaxLimitSelector(mobileData.getLabelRAM(), mobileData.getMaxRAM());
        schemaFilterSteps.setMinLimitSelector(mobileData.getLabelInternalMemory(), mobileData.getMinInternalMemory());
        schemaFilterSteps.setMaxLimitSelector(mobileData.getLabelInternalMemory(), mobileData.getMaxInternalMemory());
        schemaFilterSteps.chooseYesNoButton(mobileData.getLabelMemoryCardSupport(), mobileData.getSupportMemoryCard());

        int actual = schemaFilterSteps.getNumberFromSchemaFilterButton();
        Assert.assertEquals(actual, mobileData.getNumberOfPhones());
    }

    @TestData(jsonFile = "mobileData", model = "MobileData")
    @Test(description = "Choose the cheapest mobile phone",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
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
