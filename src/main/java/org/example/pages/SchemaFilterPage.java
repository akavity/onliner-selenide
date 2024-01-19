package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SchemaFilterPage {
    private final SelenideElement schemaHeaderField = $(By.xpath("//h1[contains(@class,'title')]"));
    private final SelenideElement filterButton = $(By.xpath("//span[contains(@class, 'n__sub_m')]"));
    private final SelenideElement additionalParametersButton = $(By.xpath("//div[contains(@class, 'addi')]/div/a"));

    public SelenideElement getCheckboxItem(String label, String checkBoxItemName) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'specific')]" +
                "/following-sibling::div/div/ul//div[contains(@class,'sign') and contains(text(),'" + checkBoxItemName + "')]"));
    }

    public SelenideElement getControlMoreButton(String label) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'specific')]" +
                "/following-sibling::div/div/div"));
    }

    public SelenideElement getPopoverColumnItem(String label, String itemName) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'specific')]" +
                "/following-sibling::div//div[contains(@class,'container')]" +
                "//div[contains(@class,'checkbox-sign') and text()='" + itemName + "']"));
    }

    public SelenideElement getMinValueField(String label) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'specific')]" +
                "/following-sibling::div//input[@placeholder='от']"));
    }

    public SelenideElement getMaxValueField(String label) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'specific')]" +
                "/following-sibling::div//input[@placeholder='до']"));
    }

    public SelenideElement getYesNoButton(String label, String decision) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'label_base')]" +
                "/following-sibling::div//span[contains(text(),'" + decision + "')]/.."));
    }

    public SelenideElement getMinLimitSelector(String label) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'label_base')]" +
                "/following-sibling::div//div[contains(@class,'input-wrapper')][1]//select"));
    }

    public SelenideElement getMaxLimitSelector(String label) {
        return $(By.xpath("//div[contains(text(),'" + label + "')]/ancestor::div[contains(@class,'label_base')]" +
                "/following-sibling::div//div[contains(@class,'input-wrapper')][2]//select"));
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
