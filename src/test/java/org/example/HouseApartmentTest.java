package org.example;

import org.example.annotations.TestData;
import org.example.models.AccomData;
import org.example.steps.AccommodationSteps;
import org.example.steps.HouseApartmentSteps;
import org.example.steps.TopNavigationSteps;
import org.example.utils.JsonReaderGson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HouseApartmentTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    HouseApartmentSteps houseSteps = new HouseApartmentSteps();
    AccommodationSteps accomSteps = new AccommodationSteps();

    @TestData(jsonFile = "accomData", model = "AccomData")
    @Test(description = "Look for accommodation",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void lookForAccommodation(AccomData accomData) {
        navigationSteps.clickTopMenuItem(accomData.getTopMenuItemName());
        houseSteps.enterMinValueOfLimit(accomData.getTitlePrice(), accomData.getMinPrice());
        houseSteps.enterMaxValueOfLimit(accomData.getTitlePrice(), accomData.getMaxPrice());
        houseSteps.chooseNumberOfRooms(accomData.getNumberRooms());
        houseSteps.enterMinValueOfLimit(accomData.getTitleArea(), accomData.getMinArea());
        houseSteps.enterMaxValueOfLimit(accomData.getTitleArea(), accomData.getMaxArea());
        houseSteps.clickTypeHomeButton(accomData.getTypeHome());
        houseSteps.chooseMaterial(accomData.getMaterial());
        houseSteps.clickUnsuitableFloorButton();
        houseSteps.enterAddress(accomData.getAddress());
        houseSteps.clickFirstAccommodation();

        int actualPrice = accomSteps.getPrice();
        int expectedMinPrice = Integer.parseInt(accomData.getMinPrice());
        int expectedMaxPrice = Integer.parseInt(accomData.getMaxPrice());
        Assert.assertTrue(actualPrice >= expectedMinPrice && actualPrice <= expectedMaxPrice);

        double actualArea = accomSteps.getArea();
        double expectedMinArea = Double.parseDouble(accomData.getMinArea());
        double expectedMaxArea = Double.parseDouble(accomData.getMaxArea());
        Assert.assertTrue(actualArea >= expectedMinArea && actualArea <= expectedMaxArea);

        Assert.assertEquals(accomSteps.getNumberRooms(), accomData.getNumberRooms());
    }
}
