package org.example.steps;

import lombok.extern.log4j.Log4j2;
import org.example.pages.TopActionsPage;
import org.example.utils.Utils;

import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class TopActionsSteps {
    TopActionsPage topActionsPage = new TopActionsPage();
    Utils utils = new Utils();

    public void enterProductName(String name) {
        topActionsPage.getFastSearchField().click();
        log.info("Enter the product name to search: " + name);
        topActionsPage.getFastSearchField().sendKeys(name);
        utils.sleep(3000);
    }

    public void clickFirstProduct() {
        log.info("Switch to frame");
        switchTo().frame(topActionsPage.getModalIframe());  //  iframe
        log.info("Click first product");
        topActionsPage.getProductTitleFields().first().click();
    }
}
