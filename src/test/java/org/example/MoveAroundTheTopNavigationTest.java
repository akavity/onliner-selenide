package org.example;

import org.example.models.TopNavigationData;
import org.example.steps.TopNavigationSteps;
import org.example.steps.ShoppingSteps;
import org.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoveAroundTheTopNavigationTest extends BaseTest {
    TopNavigationSteps topNavigationSteps = new TopNavigationSteps();
    ShoppingSteps shoppingSteps = new ShoppingSteps();

    @Test (description = "Move around the catalog",
            dataProvider = "topNavigationData", dataProviderClass = JsonReader.class)
    public void moveToSection(TopNavigationData topNavigationData) {
        topNavigationSteps.clickTopMenuItem(topNavigationData.getTopMenuItemName());
        topNavigationSteps.clickClassifierItem(topNavigationData.getClassifierItemName());
        topNavigationSteps.clickAsideListItem(topNavigationData.getClassifierItemName(),
                topNavigationData.getAsideItemName());
        topNavigationSteps.clickDropDownItem(topNavigationData.getClassifierItemName(), topNavigationData.getAsideItemName(),
        topNavigationData.getDropDownItemName());

        String actual = shoppingSteps.extractTextFromSchemaHeader();

        Assert.assertEquals(actual, topNavigationData.getSchemaHeaderText());
    }
}
