package org.example.steps;

import com.codeborne.selenide.SelenideElement;
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
        String result = schemaFilterPage.getSchemaHeadField().getText();
        log.info("//// Extract text from Schema Head: " + result);
        return result;
    }

    @Step
    public void clickCheckboxItem(String label, String checkBoxItemName) {
        log.info("click checkBox Item: " + checkBoxItemName);
        SelenideElement element = schemaFilterPage.getCheckboxItem(label, checkBoxItemName);
        element.scrollTo();
        actions().click(element).perform();
    }

    @Step
    public void enterMinValueOfLimit(String label, String minValue) {
        log.info("enter Min value of " + label + ": " + minValue);
        SelenideElement element = schemaFilterPage.getMinValueField(label);
        element.scrollTo();
        actions().click(element).sendKeys(minValue).perform();
    }

    @Step
    public void enterMaxValueOfLimit(String label, String maxValue) {
        log.info("enter Max value of " + label + ": " + maxValue);
        SelenideElement element = schemaFilterPage.getMaxValueField(label);
        element.scrollTo();
        actions().click(element).sendKeys(maxValue).perform();
    }

    @Step
    public void chooseYesNoButton(String label, String decision) {
        log.info("In section " + label + " chose button: " + decision);
        SelenideElement element = schemaFilterPage.getYesNoButton(label, decision);
        element.scrollTo();
        actions().click(element).perform();
    }

    @Step
    public void setMinLimitSelector(String label, String minValue) {
        log.info("set a minimum value of limit for " + label + ": " + minValue);
        SelenideElement element = schemaFilterPage.getMinLimitSelector(label);
        element.scrollTo();
        element.selectOption(minValue);
    }

    @Step
    public void setMaxLimitSelector(String label, String maxValue) {
        log.info("set a maximum value of limit for " + label + ": " + maxValue);
        SelenideElement element = schemaFilterPage.getMaxLimitSelector(label);
        element.scrollTo();
        element.selectOption(maxValue);
    }

    @Step
    public void clickControlMoreButton(String label) {
        log.info("Click control more button");
        SelenideElement element = schemaFilterPage.getControlMoreButton(label);
        element.scrollTo();
        element.click();
    }

    @Step
    public void clickPopoverColumnItem(String label, String itemName) {
        log.info("Click popover visible item");
        SelenideElement element = schemaFilterPage.getPopoverColumnItem(label, itemName);
        element.scrollTo();
        element.click();
    }

    @Step
    public void clickAdditionalParamButton() {
        log.info("Click Button and get more parameters");
        SelenideElement element = schemaFilterPage.getAdditionalParametersButton();
        element.scrollTo();
        element.click();
    }

    @Step
    public int getNumberFromSchemaFilterButton() {
        utils.sleep(3000);
        int result = 0;
        String text = schemaFilterPage.getFilterButton().getText();
        log.info("Text from FilterButton: " + text);
        Pattern pattern = Pattern.compile("\\d+( \\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" ", ""));
        }
        log.info("Found number phones: " + result);
        return result;
    }
}
