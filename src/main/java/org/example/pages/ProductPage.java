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
    private final SelenideElement recommendedSidebarAside = $(By.xpath("//div[contains(@class,'sidebar-aside')]"));
    private final SelenideElement yourCityPopUpWindow = $(By.xpath("//div[contains(@class,'style_visible')]"));
    private final SelenideElement yesCityButton = $(By.xpath("//span[contains(text(),'Да, верно']"));

    public SelenideElement getProductHeaderField() {
        return productHeaderField;
    }

    public ElementsCollection getCartButtons() {
        return cartButtons;
    }

    public SelenideElement getRecommendedCartButton() {
        return recommendedCartButton;
    }

    public SelenideElement getRecommendedSidebarAside() {
        return recommendedSidebarAside;
    }

    public SelenideElement getYourCityPopUpWindow() {
        return yourCityPopUpWindow;
    }

    public SelenideElement getYesCityButton() {
        return yesCityButton;
    }
}
