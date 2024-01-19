package org.example.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.SchemaProductPage;
import org.example.utils.Utils;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Log4j2
public class SchemaProductSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    SchemaProductPage schemaProductPage = new SchemaProductPage();
    Utils utils = new Utils();

    @Step
    public void sortingByOrderFilterButton(String filter) {
        SelenideElement element = schemaProductPage.getOrderFilterButton();
        element.scrollIntoView(true);
        element.sendKeys(filter);
        element.sendKeys(Keys.RETURN);
        log.info("click orderFilterButton");
        log.info("select a filter for sorting: " + filter);
    }

    @Step
    public double getPriceFirstOrder() {
        utils.sleep(2000);
        double price = getPriceFromElement(schemaProductPage.getPricesOfProductsFields().first());
        log.info("Price of the first order: " + price);
        return price;
    }

    @Step
    public String getNameFirstOrder() {
        utils.sleep(2000);
        String name = schemaProductPage.getProductsNamesFields().first().getText();
        log.info("Name of the first order: " + name);
        return name;
    }

    @Step
    public void clickTheCheapestProductOnThePage() {
        utils.sleep(3000);
        log.info("Find the cheapest product on the page");
        SelenideElement cash = findTheCheapestProductOnThePage(schemaProductPage.getPricesOfProductsFields());
        cash.scrollIntoView(PARAMETER);
        cash.click();
        log.info("Click the cheapest product on the page");
    }

    @Step
    public void clickTheCheapestProductOnThePageStream() {
        utils.sleep(3000);
        log.info("Find the cheapest product on the page by Stream");
        SelenideElement cash = findTheCheapestProductOnThePageByStream(schemaProductPage.getPricesOfProductsFields());
        cash.scrollIntoView(PARAMETER);
        cash.click();
        log.info("Click the cheapest product on the page by Stream");
    }

    @Step
    public double getOffersDescriptionPrice() {
        return getPriceFromElement(schemaProductPage.getOffersDescriptionPriceField());
    }

    private SelenideElement findTheCheapestProductOnThePage(ElementsCollection el) {
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

    private SelenideElement findTheCheapestProductOnThePageByStream(ElementsCollection el) {
        return el.asDynamicIterable()
                .stream()
                .filter(x -> getPriceFromElement(x) > 0)
                .min(priceComparator)
                .orElse(null);
    }

    Comparator<SelenideElement> priceComparator = new Comparator<SelenideElement>() {
        @Override
        public int compare(SelenideElement element1, SelenideElement element2) {
            return getPriceFromElement(element1).compareTo(getPriceFromElement(element2));
        }
    };

    private Double getPriceFromElement(SelenideElement element) {
        String text = element.getText();
        log.info("Text from element: " + text);
        double result = utils.extractDoubleFromText(text, "\\d*,\\d{2}");
        log.info("Extract double from text: " + result);
        return result;
    }
}
