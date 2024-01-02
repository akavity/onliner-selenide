package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HousePage {
    SelenideElement minPriseField = $(By.xpath("//input[contains(@id,'price-from')]"));
    SelenideElement maxPriseField = $(By.xpath("//input[contains(@id,'price-to')]"));
    SelenideElement minAreaFields = $(By.xpath("//input[contains(@id,'area-from')]"));
    SelenideElement maxAreaPrice = $(By.xpath("//input[contains(@id,'area-to')]"));
    SelenideElement oldHouseButton = $(By.xpath("//span[contains(text(), 'Вторич')]"));
    SelenideElement newHouseButton = $(By.xpath("//span[contains(text(), 'Новострой')]"));
    SelenideElement minYearField = $(By.xpath("//input[contains(@id,'year-from')]"));
    SelenideElement maxYearField = $(By.xpath("//input[contains(@id,'year-to')]"));
    SelenideElement materialsDropDown = $(By.xpath("//div[contains(@class,'multiselect')]"));
    SelenideElement unsuitableFloorButton = $(By.xpath("//span[contains(@class,'inner_left')]"));
    SelenideElement addressField = $(By.xpath("//input[contains(@placeholder,'улица')]"));

    public SelenideElement getNumberOfRooms(int number) {
        return $(By.xpath("//span[contains(@class, 'filter') and contains(text(),'" + number + "')]"));
    }

    public SelenideElement getMaterialElement(String material) {
        return $(By.xpath("//div[contains(text(),'Материал')]/..//li[contains(text(),'" + material + "')]"));
    }
}
