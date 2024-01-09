package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HouseApartmentPage {
    private final ElementsCollection accommodationsList = $$(By.xpath("//div[@class='classified']"));
    private final SelenideElement materialsDropDown = $(By.xpath("//div[contains(@class,'multiselect')]"));
    private final SelenideElement unsuitableFloorButton = $(By.xpath("//span[contains(@class,'inner_left')]"));
    private final SelenideElement addressField = $(By.xpath("//input[contains(@placeholder,'улица')]"));

    /**
     * @param title price, area, year
     */
    public SelenideElement getMinValueField(String title) {
        return $(By.xpath("//input[contains(@id,'" + title + "-from')]"));
    }

    /**
     * @param title price, area, year
     */
    public SelenideElement getMaxValueField(String title) {
        return $(By.xpath("//input[contains(@id,'" + title + "-to')]"));
    }

    /**
     * @param type Новостройка, Вторичка
     */
    public SelenideElement getTypeHouseButton(String type) {
        return $(By.xpath("//span[contains(text(), '" + type + "')]"));
    }

    public SelenideElement getNumberOfRooms(int number) {
        return $(By.xpath("//span[contains(@class, 'filter') and contains(text(),'" + number + "')]"));
    }

    /**
     * @param material Панель, Кирпич, Монолит, Блок
     */
    public SelenideElement getMaterialElement(String material) {
        return $(By.xpath("//div[contains(text(),'Материал')]/..//li[contains(text(),'" + material + "')]"));
    }

    public ElementsCollection getAccommodationsList() {
        return accommodationsList;
    }

    public SelenideElement getMaterialsDropDown() {
        return materialsDropDown;
    }

    public SelenideElement getUnsuitableFloorButton() {
        return unsuitableFloorButton;
    }

    public SelenideElement getAddressField() {
        return addressField;
    }
}
