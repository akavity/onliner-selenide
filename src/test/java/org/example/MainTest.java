package org.example;

import org.example.annotations.TestData;
import org.example.models.*;
import org.example.steps.ProductSteps;
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
    ProductSteps productSteps = new ProductSteps();

    @TestData(jsonFile = "topNavigationData", model = "TopNavigationData")
    @Test(description = "Move around the catalog",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void moveAroundCatalog(TopNavigationData topNavigationData) {
        navigationSteps.clickTopMenuItem(topNavigationData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(topNavigationData.getClassifierItemName());
        navigationSteps.clickAsideListItem(topNavigationData.getClassifierItemName(), topNavigationData.getAsideItemName());
        navigationSteps.clickDropDownItem(topNavigationData.getClassifierItemName(), topNavigationData.getAsideItemName(),
                topNavigationData.getDropDownItemName());

        String actual = schemaFilterSteps.extractTextFromSchemaHeader();
        Assert.assertEquals(actual, topNavigationData.getSchemaHeaderText());
    }

    @TestData(jsonFile = "mobileData", model = "MobileData")
    @Test(description = "Sorting phones by price, manufacturer, shop",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void sortingMobileByFilters(MobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.clickControlMoreButton(mobileData.getLabelShop());
        schemaFilterSteps.clickPopoverColumnItem(mobileData.getLabelShop(), mobileData.getShopName());
        schemaProductSteps.sortingByOrderFilterButton(mobileData.getFilter());

        String actual = schemaProductSteps.getNameFirstOrder();
        Assert.assertTrue(actual.contains(mobileData.getPieceOfName()));
    }

    @TestData(jsonFile = "mobileMemoryData", model = "MobileMemoryData")
    @Test(description = "Sorting phones by price, manufacturer, RAM,  internal memory, memory card support",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void sortingMobileByFiltersTask2(MobileMemoryData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName());
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
        schemaProductSteps.sortingByOrderFilterButton(mobileData.getFilter());

        String actual = schemaProductSteps.getNameFirstOrder();
        Assert.assertTrue(actual.contains(mobileData.getPieceOfName()));
    }

    @TestData(jsonFile = "theCheapestMobileData", model = "TheCheapestMobileData")
    @Test(description = "Choose the cheapest mobile phone",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void chooseTheCheapestMobile(TheCheapestMobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.clickControlMoreButton(mobileData.getLabelShop());
        schemaFilterSteps.clickPopoverColumnItem(mobileData.getLabelShop(), mobileData.getShopName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelDate(), mobileData.getReleaseDate());
        schemaProductSteps.clickTheCheapestProductOnThePage();

        String actual = productSteps.extractTextFromProductHeader();
        Assert.assertTrue(actual.contains(mobileData.getPieceOfName()));
    }

    @TestData(jsonFile = "theCheapestMobileData", model = "TheCheapestMobileData")
    @Test(description = "Choose the cheapest mobile phone by Stream",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void chooseTheCheapestMobileSteam(TheCheapestMobileData mobileData) {
        navigationSteps.clickTopMenuItem(mobileData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(mobileData.getClassifierItemName());
        navigationSteps.clickAsideListItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName());
        navigationSteps.clickDropDownItem(mobileData.getClassifierItemName(), mobileData.getAsideItemName(),
                mobileData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelManufacturer(), mobileData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(mobileData.getLabelPrice(), mobileData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(mobileData.getLabelPrice(), mobileData.getMaxPrice());
        schemaFilterSteps.clickControlMoreButton(mobileData.getLabelShop());
        schemaFilterSteps.clickPopoverColumnItem(mobileData.getLabelShop(), mobileData.getShopName());
        schemaFilterSteps.clickCheckboxItem(mobileData.getLabelDate(), mobileData.getReleaseDate());
        schemaProductSteps.clickTheCheapestProductOnThePageStream();

        String actual = productSteps.extractTextFromProductHeader();
        Assert.assertTrue(actual.contains(mobileData.getPieceOfName()));
    }

    @TestData(jsonFile = "tabletData", model = "TabletData")
    @Test(description = "Sorting tablet by price, manufacturer, release dat and use oderFilterButton",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void sortingTabletsBySchemaFilterAndOrderFilterButton(TabletData tabletData) {
        navigationSteps.clickTopMenuItem(tabletData.getTopMenuItemName());
        navigationSteps.clickClassifierItem(tabletData.getClassifierItemName());
        navigationSteps.clickAsideListItem(tabletData.getClassifierItemName(), tabletData.getAsideItemName());
        navigationSteps.clickDropDownItem(tabletData.getClassifierItemName(), tabletData.getAsideItemName(),
                tabletData.getDropDownItemName());
        schemaFilterSteps.clickCheckboxItem(tabletData.getLabelManufacturer(), tabletData.getManufacturerName());
        schemaFilterSteps.enterMinValueOfLimit(tabletData.getLabelPrice(), tabletData.getMinPrice());
        schemaFilterSteps.enterMaxValueOfLimit(tabletData.getLabelPrice(), tabletData.getMaxPrice());
        schemaFilterSteps.clickCheckboxItem(tabletData.getLabelDate(), tabletData.getReleaseDate());
        schemaProductSteps.sortingByOrderFilterButton(tabletData.getFilter());

        String actual = schemaProductSteps.getNameFirstOrder();
        Assert.assertTrue(actual.contains(tabletData.getPieceOfName()));
    }
}
