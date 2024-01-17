package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopActionsPage {
    private final SelenideElement fastSearchField = $(By.xpath("//input[contains(@class, 'fast-search')]"));
    private final SelenideElement authButton = $(By.xpath("//div[contains(text(), 'Вход')]"));
    private final SelenideElement cartButton = $(By.xpath("//a[@title='Корзина']/.."));

    // fast search modal
    private final ElementsCollection productTitleFields = $$(By.xpath("//div[@class='product__title']/a"));
    private final SelenideElement modalIframe = $(By.xpath("//iframe[contains(@class,'modal-iframe')]"));

    public SelenideElement getFastSearchField() {
        return fastSearchField;
    }

    public SelenideElement getAuthButton() {
        return authButton;
    }

    public SelenideElement getCartButton() {
        return cartButton;
    }

    public ElementsCollection getProductTitleFields() {
        return productTitleFields;
    }

    public SelenideElement getModalIframe() {
        return modalIframe;
    }
}
