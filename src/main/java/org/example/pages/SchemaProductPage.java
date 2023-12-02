package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SchemaProductPage {
    ElementsCollection products = $$(By.xpath(" //div[@id='schema-products']"));
    private final ElementsCollection pricesOfProductsFields = $$(By.xpath("//span[contains(@data-bind,'.minPrice')]"));
    private final SelenideElement offersDescriptionPriceField = $(By.xpath("//div[contains(@class, 'price-group')]/div"));

    public ElementsCollection getPricesOfProductsFields() {
        return pricesOfProductsFields;
    }

    public SelenideElement getOffersDescriptionPriceField() {
        return offersDescriptionPriceField;
    }
}
