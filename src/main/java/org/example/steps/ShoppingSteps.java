package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ShoppingPage;
import org.example.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class ShoppingSteps {
    ShoppingPage shoppingPage = new ShoppingPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromSchemaHeader() {
        log.info("//// Extract text from Schema Head: " + shoppingPage.getSchemaHeadText().getText());
        return shoppingPage.getSchemaHeadText().getText();
    }

    @Step
    public void closeControlElement() {
        if (shoppingPage.controlElement.isDisplayed()) {
            log.info("Found control element");
            shoppingPage.controlButton.click();
            log.info("Control element is closed");
        }
        log.info("Control element not found");
    }

    @Step
    public void clickSchemaFilterCheckboxItem(String label, String checkBoxItemName) {
        log.info("click checkBox Item: " + checkBoxItemName);
        shoppingPage.schemaFilterCheckboxItem(label, checkBoxItemName).scrollTo();
        actions().moveToElement(shoppingPage.schemaFilterCheckboxItem(label, checkBoxItemName))
                .click(shoppingPage.schemaFilterCheckboxItem(label, checkBoxItemName)).perform();
    }

    @Step
    public void enterMinValueOfLimit(String label, String minValue) {
        log.info("enter minValue of " + label + ": " + minValue);
        shoppingPage.minValueField(label).scrollTo();
        actions().click(shoppingPage.minValueField(label)).sendKeys(minValue).perform();
    }

    @Step
    public void enterMaxValueOfLimit(String label, String maxValue) {
        log.info("enter maxValue " + label + ": " + maxValue);
        shoppingPage.maxValueField(label).scrollTo();
        actions().click(shoppingPage.maxValueField(label)).sendKeys(maxValue).perform();
    }

    @Step
    public void clickSchemaFilterDropDown(String label) {
        log.info("");
        shoppingPage.schemaFilterDropDown(label).click();
    }

    @Step
    public void clickPopoverVisibleItem(String label, String itemName) {
        log.info("");
        shoppingPage.popoverVisibleItem(label, itemName).click();
    }

    @Step
    public int getNumberFromSchemaFilterButton() {
        utils.sleep(3000);
        int result = 0;
        String text = shoppingPage.schemaFilterButton().getText();
        log.info("Text from FilterButton: " + shoppingPage.schemaFilterButton().getText());
        Pattern pattern = Pattern.compile("\\d+( \\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" ", ""));
        }
        log.info("Found number phones: " + result);
        return result;
    }
}
