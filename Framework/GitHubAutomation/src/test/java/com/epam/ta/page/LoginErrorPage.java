package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginErrorPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();

    private final String XPATH_FOR_LOGIN_ERROR = "//*[@id=\"client\"]/div[2]/div[1]/div/div/span";

    private WebElement loginErrorMessage;

    public LoginErrorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginErrorPage openPage(){
        LOGGER.info("Login error page opened");
        return this;
    }

    public String getLoginErrorMessage(){
        loginErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_LOGIN_ERROR)));
        return loginErrorMessage.getText();
    }
}
