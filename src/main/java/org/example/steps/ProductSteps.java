package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ProductPage;
import org.example.pages.TopActionsPage;
import org.example.utils.Utils;

@Log4j2
public class ProductSteps {
    ProductPage productPage = new ProductPage();
    TopActionsPage topActionsPage = new TopActionsPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromProductHeader() {
        String result = productPage.getProductHeaderField().getText();
        log.info("//// Extract text from Product Head: " + result);
        return result;
    }

    @Step
    public void addToCart() {
        log.info("Added first product to cart");
        productPage.getCartButtons().first().click();
    }

    @Step
    public void closeYourCityPopUpWindow() {
        if (productPage.getYourCityPopUpWindow().isDisplayed()) {
            log.info("Closed your city pop-up window");
            productPage.getYesCityButton().click();
        }
    }

    @Step
    public void clickRecommendedCartButton() {
        log.info("Click recommended cart button");
        utils.sleep(1000);
        if (productPage.getRecommendedSidebarAside().isDisplayed()) {
            log.info("Recommended sidebar aside is displayed");
            productPage.getRecommendedCartButton().click();
        } else {
            log.info("Recommended sidebar aside isn't displayed");
            topActionsPage.getCartButton().click();
        }
    }
}
