package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthContainerPage {
    private final SelenideElement nickField = $(By.xpath("//input[contains(@placeholder, 'e-mail')]"));
    private final SelenideElement passwordField = $(By.xpath("//input[@placeholder='Пароль']"));
    private final SelenideElement submitField = $(By.xpath("//button[contains(text(), 'Войти')]"));
    private final SelenideElement registerButton = $(By.xpath("//a[contains(text(), 'Зарегист')]"));
    private final SelenideElement authPasswordField = $(By.xpath("//input[contains(@placeholder, 'Придум')]"));
    private final SelenideElement authRepeatPasField = $(By.xpath("//input[contains(@placeholder, 'Повтор')]"));
    private final SelenideElement authButton = $(By.xpath("//button[@type='submit']"));

    public SelenideElement getErrorField(String error) {
        return $(By.xpath("//div[contains(@class, 'on_error') and contains (text(), '" + error + "')]"));
    }

    public SelenideElement getNickField() {
        return nickField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getSubmitField() {
        return submitField;
    }

    public SelenideElement getRegisterButton() {
        return registerButton;
    }

    public SelenideElement getAuthPasswordField() {
        return authPasswordField;
    }

    public SelenideElement getAuthRepeatPasField() {
        return authRepeatPasField;
    }

    public SelenideElement getAuthButton() {
        return authButton;
    }
}
