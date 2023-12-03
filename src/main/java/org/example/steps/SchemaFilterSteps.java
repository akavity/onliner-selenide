package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.SchemaFilterPage;
import org.example.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class SchemaFilterSteps {
    SchemaFilterPage schemaFilterPage = new SchemaFilterPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromSchemaHeader() {
        log.info("//// Extract text from Schema Head: " + schemaFilterPage.getSchemaHeadField().getText());
        return schemaFilterPage.getSchemaHeadField().getText();
    }

    @Step
    public void closeControlElement() {
        if (schemaFilterPage.getFilterButton().isDisplayed()) {
            log.info("Found control element");
            schemaFilterPage.getFilterButton().click();
            log.info("Control element is closed");
        }
        log.info("Control element not found");
    }

    @Step
    public void clickCheckboxItem(String label, String checkBoxItemName) {
        log.info("click checkBox Item: " + checkBoxItemName);
        schemaFilterPage.getCheckboxItem(label, checkBoxItemName).scrollTo();
        actions().moveToElement(schemaFilterPage.getCheckboxItem(label, checkBoxItemName))
                .click(schemaFilterPage.getCheckboxItem(label, checkBoxItemName)).perform();
    }

    @Step
    public void enterMinValueOfLimit(String label, String minValue) {
        log.info("enter Min value of " + label + ": " + minValue);
        schemaFilterPage.getMinValueField(label).scrollTo();
        actions().click(schemaFilterPage.getMinValueField(label)).sendKeys(minValue).perform();
    }

    @Step
    public void enterMaxValueOfLimit(String label, String maxValue) {
        log.info("enter Max value of " + label + ": " + maxValue);
        schemaFilterPage.getMaxValueField(label).scrollTo();
        actions().click(schemaFilterPage.getMaxValueField(label)).sendKeys(maxValue).perform();
    }

    @Step
    public void enterNimMaxValuesOfLimit(String label, String minValue, String maxValue) {
        log.info("enter Min value " + minValue + " enter Max value " + maxValue + " of " + label);
        schemaFilterPage.getMinValueField(label).scrollTo();
        actions().click(schemaFilterPage.getMinValueField(label)).sendKeys(minValue).perform();
        actions().click(schemaFilterPage.getMaxValueField(label)).sendKeys(maxValue).perform();
    }

    @Step
    public void chooseYesNoButton(String label, String decision) {
        log.info("chose button: " + decision);
        schemaFilterPage.getYesNoButton(label, decision).scrollTo();
        actions().click(schemaFilterPage.getYesNoButton(label, decision)).perform();
    }

    @Step
    public void setMinLimitSelector(String label, String minValue) {
        log.info("set a minimum value of limit for " + label + ": " + minValue);
        schemaFilterPage.getMinLimitSelector(label).scrollTo();
        schemaFilterPage.getMinLimitSelector(label).selectOption(minValue);
    }

    @Step
    public void setMaxLimitSelector(String label, String maxValue) {
        log.info("set a maximum value of limit for " + label + ": " + maxValue);
        schemaFilterPage.getMaxLimitSelector(label).scrollTo();
        schemaFilterPage.getMaxLimitSelector(label).selectOption(maxValue);
    }

    @Step
    public void clickControlMoreButton(String label) {
        log.info("Click schema filter drop down");
        schemaFilterPage.getControlMoreButton(label).click();
    }

    @Step
    public void clickPopoverColumnItem(String label, String itemName) {
        log.info("Click popover visible item");
        schemaFilterPage.getPopoverColumnItem(label, itemName).click();
    }

    @Step
    public int getNumberFromSchemaFilterButton() {
        utils.sleep(3000);
        int result = 0;
        String text = schemaFilterPage.getFilterButton().getText();
        log.info("Text from FilterButton: " + schemaFilterPage.getFilterButton().getText());
        Pattern pattern = Pattern.compile("\\d+( \\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" ", ""));
        }
        log.info("Found number phones: " + result);
        return result;
    }
}
