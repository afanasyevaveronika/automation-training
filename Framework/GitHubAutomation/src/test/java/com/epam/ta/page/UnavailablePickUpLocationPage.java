package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnavailablePickUpLocationPage extends AbstractPage {

    private final String XPATH_FOR_ERROR_Message = "//*[@id=\"boxRetirada\"]/h3";

    private WebElement errorMessage;

    public UnavailablePickUpLocationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public UnavailablePickUpLocationPage openPage(){
        return this;
    }

    public String getErrorMessage(){
        errorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ERROR_Message)));
        return errorMessage.getText();
    }
}
