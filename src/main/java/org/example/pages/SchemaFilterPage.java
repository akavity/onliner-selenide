package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SchemaFilterPage {
    public SelenideElement schemaHeaderField = $(By.xpath("//div[@class='schema-header']/h1"));
    private final SelenideElement filterButton = $(By.xpath("//span[contains(@class, 'n__sub_m')]"));

    private final SelenideElement additionalParametersButton = $(By.xpath("//div[contains(@class, 'addi')]/div/a"));

    public SelenideElement getCheckboxItem(String label, String checkBoxItemName) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//li//span[contains (text(), '" + checkBoxItemName + "')]"));
    }

    public SelenideElement getControlMoreButton(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../..//div[contains(@class,'control schema')]"));
    }

    public SelenideElement getPopoverColumnItem(String label, String itemName) {
        return $(By.xpath("//div[contains(text(), '" + label + "')]" +
                "/following-sibling::div//span[contains(text(), '" + itemName + "')]"));
    }

    public SelenideElement getMinValueField(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//div[contains(@class, 'control')][1]"));
    }

    public SelenideElement getMaxValueField(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//div[contains(@class, 'control')][2]"));
    }

    public SelenideElement getYesNoButton(String label, String decision) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//span[contains(text(), '" + decision + "')]"));
    }

    public SelenideElement getMinLimitSelector(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//div[contains(@class, 'cont')][1]/select"));
    }

    public SelenideElement getMaxLimitSelector(String label) {
        return $(By.xpath("//span[contains(text(), '" + label + "')]" +
                "/../following-sibling::div//div[contains(@class, 'cont')][2]/select"));
    }

    public SelenideElement getFilterButton() {
        return filterButton;
    }

    public SelenideElement getSchemaHeadField() {
        return schemaHeaderField;
    }

    public SelenideElement getAdditionalParametersButton() {
        return additionalParametersButton;
    }
}
