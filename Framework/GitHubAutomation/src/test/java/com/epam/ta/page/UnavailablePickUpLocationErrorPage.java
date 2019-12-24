package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnavailablePickUpLocationErrorPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();

    private final String XPATH_FOR_ERROR_Message = "//*[@id=\"wrapper-vue-container\"]/div/div/div[3]/div/div/span[2]";

    private WebElement errorMessage;

    public UnavailablePickUpLocationErrorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public UnavailablePickUpLocationErrorPage openPage(){
        LOGGER.info("Unavailable pick-up location error page opened");
        return this;
    }

    public String getErrorMessage(){
        errorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ERROR_Message)));
        return errorMessage.getText();
    }
}
