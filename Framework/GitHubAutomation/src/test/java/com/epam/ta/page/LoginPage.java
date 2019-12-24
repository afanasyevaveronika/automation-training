package com.epam.ta.page;

import com.epam.ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[1]/div/div/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[2]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[3]/input")
    private WebElement loginButton;


    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage(){
        LOGGER.info("Login page opened");
        return this;
    }

    public LoginErrorPage redirectToLoginPageError(User userInformation){
        loginToWebSite(userInformation);
        return new LoginErrorPage(driver);
    }

    public void loginToWebSite (User userInformation){
        usernameInput.sendKeys(userInformation.getUsername());
        passwordInput.sendKeys(userInformation.getPassword());
        loginButton.click();
    }
}
