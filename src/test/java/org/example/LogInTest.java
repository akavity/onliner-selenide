package org.example;

import org.example.steps.AuthContainerSteps;
import org.example.steps.TopNavigationSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    TopNavigationSteps navigationSteps = new TopNavigationSteps();
    AuthContainerSteps authContainerSteps = new AuthContainerSteps();

    @Test
    public void enterIncorrectNickOrPassword() {
        navigationSteps.clickAuthorizationButton();
        authContainerSteps.enterNick("ArturPirogkov");
        authContainerSteps.enterPassword("123dfddf$ggg");
        authContainerSteps.clickSubmitButton();

        Assert.assertTrue(authContainerSteps.isThereAnError("Неверный логин или пароль"));
    }
}
