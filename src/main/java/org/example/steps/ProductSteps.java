package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ProductPage;

@Log4j2
public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Step
    public String extractTextFromProductHeader() {
        String result = productPage.getProductHeaderField().getText();
        log.info("//// Extract text from Product Head: " + result);
        return result;
    }
}
