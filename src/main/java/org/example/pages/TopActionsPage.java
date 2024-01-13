package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopActionsPage {
    private final SelenideElement fastSearchField = $(By.xpath("//form[contains(@class, 'fast-search')]"));
    private final SelenideElement authButton = $(By.xpath("//div[contains(text(), 'Вход')]")); // remove logInButton in TopNavigation
    private final SelenideElement cartButton = $(By.xpath("//a[@title='Корзина']/.."));

    public SelenideElement getFastSearchField() {
        return fastSearchField;
    }

    public SelenideElement getAuthButton() {
        return authButton;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }
}
