package org.example;

import org.example.annotations.TestData;
import org.example.models.TopNavigationData;
import org.example.steps.SchemaFilterSteps;
import org.example.steps.TopNavigationSteps;
import org.example.utils.JsonReaderGson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    SchemaFilterSteps schemaFilterSteps = new SchemaFilterSteps();

    @TestData(jsonFile = "topNavigationData", model = "TopNavigationData")
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
}
