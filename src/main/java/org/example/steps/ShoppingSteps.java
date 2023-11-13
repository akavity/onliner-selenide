package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.ShoppingPage;

@Log4j2
public class ShoppingSteps {
    ShoppingPage shoppingPage = new ShoppingPage();

    @Step
    public String extractTextFromSchemaHeader() {
        log.info("//// Extract text from Schema Head: " + shoppingPage.getSchemaHeadText().getText());
       return shoppingPage.getSchemaHeadText().getText();
    }
}
