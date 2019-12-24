package com.epam.ta.page;

import com.epam.ta.model.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends AbstractPage {
    private final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"formGuestMenu\"]/div[1]/div/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"formGuestMenu\"]/div[2]/div/input")
    private WebElement bookingCodeInput;


    @FindBy(xpath = "//*[@id=\"formGuestMenu\"]/div[5]/input")
    private WebElement checkBookingButton;

    private final String XPATH_FOR_BOOKING_ERROR = "//*[@id=\"formGuestMenu\"]/div[3]/span";
    private WebElement bookingErrorMessage;

    public BookingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BookingPage openPage(){
        LOGGER.info("Booking page opened");
        return this;
    }

    public String getErrorMessage(Booking bookingInformation){
        inputBookingInformation(bookingInformation);
        bookingErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_BOOKING_ERROR)));
        return bookingErrorMessage.getText();
    }

    public void inputBookingInformation (Booking bookingInformation){
        usernameInput.sendKeys(bookingInformation.getUsername());
        bookingCodeInput.sendKeys(bookingInformation.getBookingCode());
        LOGGER.info("Username input: "+bookingInformation.getUsername()+", booking code input: "+bookingInformation.getBookingCode());
        checkBookingButton.click();
    }
}
