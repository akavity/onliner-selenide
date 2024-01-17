package org.example.steps;

import lombok.extern.log4j.Log4j2;
import org.example.pages.CartPage;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();

    public String extractTextFromProductTitle() {
        String text = cartPage.getProductTitle().getText();
        log.info("Extract text from product title: " + text);
        return text;
    }
}
