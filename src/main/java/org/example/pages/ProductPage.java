package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement productHeaderField = $(By.xpath("//div[@class='catalog-masthead']/h1"));

    public SelenideElement getProductHeaderField() {
        return productHeaderField;
    }
}
