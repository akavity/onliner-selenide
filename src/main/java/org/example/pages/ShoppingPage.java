package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
    ElementsCollection products = $$(By.xpath(" //div[@id='schema-products']"));
    private final ElementsCollection pricesOfProductsFields = $$(By.xpath("//span[contains(@data-bind,'.minPrice')]"));
    public SelenideElement schemaHeaderField = $(By.xpath("//div[@class='schema-header']/h1"));
    public SelenideElement controlElement = $(By.xpath("//div[contains(@class, 'schema-filter-button__inner-container')]"));
    public SelenideElement controlButton = $(By.xpath("//span[contains(@class, 'button__sub_control')]"));
    private final SelenideElement schemaFilterButton = $(By.xpath("//span[contains(@class, 'n__sub_m')]"));
    private final SelenideElement offersDescriptionPriceField = $(By.xpath("//div[contains(@class, 'price-group')]/div"));

    public SelenideElement getSchemaFilterCheckboxItem(String label, String checkBoxItemName) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "//..//../div[contains(@class, 'facet')]//li//span[contains(text(), '" + checkBoxItemName + "')]/.."));
    }

    public SelenideElement getSchemaFilterDropDown(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "//..//../div[contains(@class, 'facet')]/div[contains(@class,'control')]"));
    }

    public SelenideElement getPopoverVisibleItem(String label, String itemName) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//span[contains(text(), '" + itemName + "')]"));
    }

    public SelenideElement getMinValueField(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/..//../div[contains(@class, 'facet')]//div[contains(@class, 'control_input')][1]"));
    }

    public SelenideElement getMaxValueField(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/..//../div[contains(@class, 'facet')]//div[contains(@class, 'control_input')][2]"));
    }

    //span[contains(@data-bind,'.full_name')]     название продуктов;
    //span[contains(@data-bind,'.minPrice')]      цена продуктов
    //div[@class="schema-product__status"]  нет в наличии
    //div[@class="schema-product__offers"] количество предложений
    //div[contains(@class, "schema-product")]

    public SelenideElement getSchemaFilterButton() {
        return schemaFilterButton;
    }

    public SelenideElement getSchemaHeadText() {
        return schemaHeaderField;
    }

    public ElementsCollection getPricesOfProductsFields() {
        return pricesOfProductsFields;
    }

    public SelenideElement getOffersDescriptionPriceField() {
        return offersDescriptionPriceField;
    }
}
