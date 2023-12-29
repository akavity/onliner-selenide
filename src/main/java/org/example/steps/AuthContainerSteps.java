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
        authContainerPage.getNickField().sendKeys(nick);
        log.info("Enter nick or email: " + nick);
    }

    public void enterPassword(String password) {
        authContainerPage.getPasswordField().sendKeys(password);
        log.info("Enter the password: " + password);
    }

    public void clickAuthButton() {
        authContainerPage.getAuthButton().click();
        log.info("Click the submit button");
    }

    public void clickRegField() {
        authContainerPage.getRegisterField().click();
        log.info("Click the registration button");
    }

    // Registration

    public void enterRegPassword(String password) {
        authContainerPage.getRegPasswordField().sendKeys(password);
        log.info("Enter the authorization password: " + password);
    }

    public void repeatRegPassword(String password) {
        authContainerPage.getRepeatRegPasswordField().sendKeys(password);
        log.info("Repeat the authorization password: " + password);
    }

    public void giveConsent() {
        authContainerPage.getConsentItem().click();
        log.info("Give consent");
    }

    public void clickRegisterButton() {
        authContainerPage.getRegisterButton().click();
        log.info("Click the authorization button");
    }

    public boolean isThereAnError(String error) {
        utils.sleep(1000);
        boolean result = authContainerPage.getErrorField(error).isDisplayed();
        log.info("/// Is the error field ('" + error + "') displayed: " + result);
        return result;
    }
}
