package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement productTitle = $(By.xpath("//div[contains(@class,'condensed-specific')]"));

    public SelenideElement getProductTitle() {
        return productTitle;
    }
}
