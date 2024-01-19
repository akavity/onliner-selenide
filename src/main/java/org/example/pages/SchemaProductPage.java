package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SchemaProductPage {
    private final ElementsCollection products = $$(By.xpath("//div[@id='schema-products']"));
    private final ElementsCollection pricesOfProductsFields = $$(By.xpath("//a[contains(@href,'prices')]/span[not(@class)]"));
    private final ElementsCollection productsNamesFields = $$(By.xpath("//div[contains(@class,'data')]//a[contains(@class,'primary')]"));
    private final SelenideElement offersDescriptionPriceField = $(By.xpath("//div[contains(@class, 'price-group')]/div"));
    private final SelenideElement orderFilterButton = $(By.xpath("//div[contains(@class,'sorting')]//select[contains(@class,'real')]"));

    public ElementsCollection getProducts() {
        return products;
    }

    public ElementsCollection getPricesOfProductsFields() {
        return pricesOfProductsFields;
    }

    public ElementsCollection getProductsNamesFields() {
        return productsNamesFields;
    }

    public SelenideElement getOffersDescriptionPriceField() {
        return offersDescriptionPriceField;
    }

    public SelenideElement getOrderFilterButton() {
        return orderFilterButton;
    }
}
