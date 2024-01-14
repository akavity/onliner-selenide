package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private final SelenideElement productHeaderField = $(By.xpath("//div[@class='catalog-masthead']/h1"));
    private final ElementsCollection cartButtons = $$(By.xpath("//a[contains(@class,'button_cart')]"));
    private final SelenideElement recommendedCartButton = $(By.xpath("//a[contains(text(),'в корзину')]"));

    public SelenideElement getProductHeaderField() {
        return productHeaderField;
    }

    public ElementsCollection getCartButtons() {
        return cartButtons;
    }

    public SelenideElement getRecommendedCartButton() {
        return recommendedCartButton;
    }
}
