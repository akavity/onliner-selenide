package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthContainerPage {
    private final SelenideElement nickField = $(By.xpath("//input[contains(@placeholder, 'e-mail')]"));
    private final SelenideElement passwordField = $(By.xpath("//input[@placeholder='Пароль']"));
    private final SelenideElement authButton = $(By.xpath("//button[contains(text(), 'Войти')]"));
    private final SelenideElement registerField = $(By.xpath("//a[contains(text(), 'Зарегист')]"));
    private final SelenideElement regPasswordField = $(By.xpath("//input[contains(@placeholder, 'Придум')]"));
    private final SelenideElement repeatRegPasField = $(By.xpath("//input[contains(@placeholder, 'Повтор')]"));
    private final SelenideElement consentItem = $(By.xpath("//span[@class=\"auth-checkbox__faux\"]"));
    private final SelenideElement registerButton = $(By.xpath("//button[@type='submit']"));

    public SelenideElement getErrorField(String error) {
        return $(By.xpath("//div[contains(@class, 'on_error') and contains (text(), '" + error + "')]"));
    }

    public SelenideElement getNickField() {
        return nickField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getAuthButton() {
        return authButton;
    }

    public SelenideElement getRegisterField() {
        return registerField;
    }

    public SelenideElement getRegPasswordField() {
        return regPasswordField;
    }

    public SelenideElement getRepeatRegPasswordField() {
        return repeatRegPasField;
    }

    public SelenideElement getRegisterButton() {
        return registerButton;
    }

    public SelenideElement getConsentItem() {
        return consentItem;
    }
}
