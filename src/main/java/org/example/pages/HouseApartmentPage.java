package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HouseApartmentPage {
//    SelenideElement minPriseField = $(By.xpath("//input[contains(@id,'price-from')]"));
//    SelenideElement maxPriseField = $(By.xpath("//input[contains(@id,'price-to')]"));
//    SelenideElement minAreaFields = $(By.xpath("//input[contains(@id,'area-from')]"));
//    SelenideElement maxAreaPrice = $(By.xpath("//input[contains(@id,'area-to')]"));
//    SelenideElement minYearField = $(By.xpath("//input[contains(@id,'year-from')]"));
//    SelenideElement maxYearField = $(By.xpath("//input[contains(@id,'year-to')]"));

//    SelenideElement oldHouseButton = $(By.xpath("//span[contains(text(), 'Вторич')]"));
//    SelenideElement newHouseButton = $(By.xpath("//span[contains(text(), 'Новострой')]"));

    private final ElementsCollection accommodationsList = $$(By.xpath("//div[@class='classifieds-list']"));
    private final SelenideElement materialsDropDown = $(By.xpath("//div[contains(@class,'multiselect')]"));
    private final SelenideElement unsuitableFloorButton = $(By.xpath("//span[contains(@class,'inner_left')]"));
    private final SelenideElement addressField = $(By.xpath("//input[contains(@placeholder,'улица')]"));

//    /**
//     * @param title price, area, year
//     * @param max   choose max limit value or min limit value
//     * @return SelenideElement
//     */
//    public SelenideElement getValueField(String title, boolean max) {
//        String word;
//        if (max) {
//            word = "-to";
//        } else {
//            word = "-from";
//        }
//        return $(By.xpath("//input[contains(@id,'" + title + word + "')]"));
//    }

    /**
     * @param title price, area, year
     * @return SelenideElement
     */
    public SelenideElement getMinValueField(String title) {
        return $(By.xpath("//input[contains(@id,'" + title + "-from')]"));
    }

    /**
     * @param title price, area, year
     * @return SelenideElement
     */
    public SelenideElement getMaxValueField(String title) {
        return $(By.xpath("//input[contains(@id,'" + title + "-to')]"));
    }

    /**
     * @param type Новостройка, Вторичка
     * @return SelenideElement
     */
    public SelenideElement getTypeHouseButton(String type) {
        return $(By.xpath("//span[contains(text(), '" + type + "')]"));
    }

    public SelenideElement getNumberOfRooms(int number) {
        return $(By.xpath("//span[contains(@class, 'filter') and contains(text(),'" + number + "')]"));
    }

    /**
     * @param material Панель, Кирпич, Монолит, Блок
     * @return SelenideElement
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
