package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClosedStoresErrorPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();


    private final String XPATH_NAME_FOR_CLOSED_STORES_ERROR_MESSAGE = "//*[@id=\"wrapper-vue-container\"]/div/div/div[3]/div[1]/div[2]/div[3]";

    private WebElement closedStoresErrorMessage;

    public ClosedStoresErrorPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ClosedStoresErrorPage openPage(){
        LOGGER.info("Closed stores error page opened");
        return this;
    }

    public String getClosedStoresErrorMessage() {
        closedStoresErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_NAME_FOR_CLOSED_STORES_ERROR_MESSAGE)));
        return closedStoresErrorMessage.getText();
    }
}
