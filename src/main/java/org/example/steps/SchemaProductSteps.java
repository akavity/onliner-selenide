package org.example.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.SchemaProductPage;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SchemaProductSteps {
    SchemaProductPage schemaProductPage = new SchemaProductPage();
    Utils utils = new Utils();

    @Step
    public void sortingByOrderFilterButton(String filter) {
        schemaProductPage.getOrderFilterButton().scrollTo();
        schemaProductPage.getOrderFilterButton().click();
        log.info("click orderFilterButton");
        schemaProductPage.getTypeFilterItem(filter).click();
        log.info("select a filter for sorting");
    }

    @Step
    public double getPriceFirstOrder() {
        utils.sleep(2000);
        return getPriceFromElement(schemaProductPage.getPricesOfProductsFields().first());
    }

    @Step
    public String getNameFirstOrder() {
        utils.sleep(2000);
        return schemaProductPage.getProductsNamesFields().first().getText();
    }

    @Step
    public void clickTheCheapestProduct() {
        utils.sleep(3000);
        SelenideElement cash = findTheCheapestProduct(schemaProductPage.getPricesOfProductsFields());
        cash.scrollTo();
        cash.click();
    }

    @Step
    public double getOffersDescriptionPrice() {
        return getPriceFromElement(schemaProductPage.getOffersDescriptionPriceField());
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

        log.info("The cheapest product has price :" + lowPrice);
        return theCheapestElement;
    }

    private double getPriceFromElement(SelenideElement element) {
        return Double.parseDouble(element.getText()
                .replace(",", ".")
                .replace(" р.", ""))
                * 100 / 100;
    }
}
