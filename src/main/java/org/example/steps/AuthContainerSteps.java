package org.example.steps;

import lombok.extern.log4j.Log4j2;
import org.example.pages.AuthContainerPage;
import org.example.utils.Utils;

@Log4j2
public class AuthContainerSteps {
    AuthContainerPage authContainerPage = new AuthContainerPage();
    Utils utils = new Utils();

    // Log in

    public void enterNick(String nick) {
        log.info("Enter nick or email: " + nick);
        authContainerPage.getNickField().sendKeys(nick);
    }

    public void enterPassword(String password) {
        log.info("Enter the password: " + password);
        authContainerPage.getPasswordField().sendKeys(password);
    }

    public void clickAuthButton() {
        log.info("Click the submit button");
        authContainerPage.getAuthButton().click();
    }

    public void clickRegField() {
        log.info("Click the registration button");
        authContainerPage.getRegisterField().click();
    }

    // Registration

    public void enterRegPassword(String password) {
        log.info("Enter the authorization password: " + password);
        authContainerPage.getRegPasswordField().sendKeys(password);
    }

    public void repeatRegPassword(String password) {
        log.info("Repeat the authorization password: " + password);
        authContainerPage.getRepeatRegPasswordField().sendKeys(password);
    }

    public void giveConsent() {
        log.info("Give consent");
        authContainerPage.getConsentItem().click();
    }

    public void clickRegisterButton() {
        log.info("Click the authorization button");
        authContainerPage.getRegisterButton().click();
    }

    public boolean isThereAnError(String error) {
        utils.sleep(1000);
        boolean result = authContainerPage.getErrorField(error).isDisplayed();
        log.info("/// Is the error field ('" + error + "') displayed: " + result);
        return result;
    }
}
