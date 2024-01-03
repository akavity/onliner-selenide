package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccommodationPage {
    private final SelenideElement numberRoomsField = $(By.xpath("//span[contains(text(), 'квартира')]"));
    private final SelenideElement priceField = $(By.xpath("//span[contains(@class, 'price_second')]/span"));
    private final SelenideElement areaField = $(By.xpath("//span[contains(text(), 'Общая')]/../../following-sibling::td"));

    public SelenideElement getNumberRoomsField() {
        return numberRoomsField;
    }

    public SelenideElement getPriceField() {
        return priceField;
    }

    public SelenideElement getAreaField() {
        return areaField;
    }
}
