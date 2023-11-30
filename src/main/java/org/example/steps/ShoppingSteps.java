package org.example.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ShoppingPage;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;
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
        shoppingPage.getSchemaFilterCheckboxItem(label, checkBoxItemName).scrollTo();
        actions().moveToElement(shoppingPage.getSchemaFilterCheckboxItem(label, checkBoxItemName))
                .click(shoppingPage.getSchemaFilterCheckboxItem(label, checkBoxItemName)).perform();
    }

    @Step
    public void enterMinValueOfLimit(String label, String minValue) {
        log.info("enter minValue of " + label + ": " + minValue);
        shoppingPage.getMinValueField(label).scrollTo();
        actions().click(shoppingPage.getMinValueField(label)).sendKeys(minValue).perform();
    }

    @Step
    public void enterMaxValueOfLimit(String label, String maxValue) {
        log.info("enter maxValue " + label + ": " + maxValue);
        shoppingPage.getMaxValueField(label).scrollTo();
        actions().click(shoppingPage.getMaxValueField(label)).sendKeys(maxValue).perform();
    }

    @Step
    public void clickSchemaFilterDropDown(String label) {
        log.info("");
        shoppingPage.getSchemaFilterDropDown(label).click();
    }

    @Step
    public void clickPopoverVisibleItem(String label, String itemName) {
        log.info("");
        shoppingPage.getPopoverVisibleItem(label, itemName).click();
    }

    @Step
    public int getNumberFromSchemaFilterButton() {
        utils.sleep(3000);
        int result = 0;
        String text = shoppingPage.getSchemaFilterButton().getText();
        log.info("Text from FilterButton: " + shoppingPage.getSchemaFilterButton().getText());
        Pattern pattern = Pattern.compile("\\d+( \\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" ", ""));
        }
        log.info("Found number phones: " + result);
        return result;
    }

    @Step
    public void clickTheCheapestProduct() {
        utils.sleep(3000);
        SelenideElement cash = findTheCheapestProduct(shoppingPage.getPricesOfProductsFields());
        cash.scrollTo();
        cash.click();
    }

    @Step
    public double getOffersDescriptionPrice() {
        return getPriceFromElement(shoppingPage.getOffersDescriptionPriceField());
    }

    private SelenideElement findTheCheapestProduct(ElementsCollection el) {
        log.info("Size of the created array : " + el.size());
        List<SelenideElement> pricesOfProducts = new ArrayList<>(el);
        SelenideElement theCheapestElement = pricesOfProducts.get(0);
        double lowPrice = getPriceFromElement(pricesOfProducts.get(0));

        for (int i = 1; i < pricesOfProducts.size(); i++) {
            if (lowPrice > getPriceFromElement(pricesOfProducts.get(i))) {
                lowPrice = getPriceFromElement(pricesOfProducts.get(i));
                theCheapestElement = pricesOfProducts.get(i);
            }
        }

        log.info("theCheapestElement :" + theCheapestElement);
        return theCheapestElement;
    }

    private double getPriceFromElement(SelenideElement element) {
        return Double.parseDouble(element.getText()
                .replace(",", ".")
                .replace(" р.", ""));
    }
}
