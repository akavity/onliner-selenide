package org.example;

import org.example.annotations.TestData;
import org.example.models.AuthData;
import org.example.models.RegData;
import org.example.steps.AuthContainerSteps;
import org.example.steps.TopActionsSteps;
import org.example.utils.JsonReaderGson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    AuthContainerSteps authContainerSteps = new AuthContainerSteps();
    TopActionsSteps topActionsSteps = new TopActionsSteps();

    @TestData(jsonFile = "authData", model = "AuthData")
    @Test(description = "Enter incorrect nick or password",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void enterIncorrectNickOrPassword(AuthData authData) {
        topActionsSteps.clickAuthButton();
        authContainerSteps.enterNick(authData.getNick());
        authContainerSteps.enterPassword(authData.getPassword());
        authContainerSteps.clickAuthButton();

        Assert.assertTrue(authContainerSteps.isThereAnError(authData.getError()));
    }

    @TestData(jsonFile = "regData", model = "RegData")
    @Test(description = "Get registration error",
            dataProviderClass = JsonReaderGson.class, dataProvider = "getData")
    public void getRegistrationError(RegData regData) {
        topActionsSteps.clickAuthButton();
        authContainerSteps.clickRegField();
        authContainerSteps.enterNick(regData.getNick());
        authContainerSteps.enterRegPassword(regData.getPassword());
        authContainerSteps.repeatRegPassword(regData.getRepeatPassword());
        authContainerSteps.giveConsent();
        authContainerSteps.clickRegisterButton();

        Assert.assertTrue(authContainerSteps.isThereAnError(regData.getError()));
    }
}
