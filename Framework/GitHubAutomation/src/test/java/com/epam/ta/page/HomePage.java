package com.epam.ta.page;

import com.epam.ta.model.CarRentOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.epam.ta.util.StringUtils.HOMEPAGE_URL;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"SuggestPickup\"]")
    private WebElement pickUpLocationInput;

    @FindBy(xpath = "//*[@id=\"SuggestDropOff\"]")
    private WebElement dropOffLocationInput;

    @FindBy(xpath = "//*[@id=\"DataRetirada\"]")
    private WebElement pickUpDateInput;

    @FindBy(xpath = "//*[@id=\"DataDevolucao\"]")
    private WebElement dropOffDateInput;

    @FindBy(xpath = "//*[@id=\"HoraRetirada\"]")
    private WebElement pickUpTimeInput;

    @FindBy(xpath = "//*[@id=\"HoraDevolucao\"]")
    private WebElement dropOffTimeInput;

    @FindBy(xpath = "//*[@id=\"dropdown-offline\"]")
    private WebElement logInSignUpButton;

    @FindBy(xpath = "//*[@id=\"submitPesquisa\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"wrapper-vue-container\"]/button")
    private WebElement selectCarButton;

    @FindBy(xpath = "//*[@id=\"clientMyBookings\"]/div")
    private WebElement bookingButton;

    @FindBy(xpath = "//*[@id=\"dropLocation\"]")
    private WebElement droppOffLocationCheck;

    @FindBy(className = "available")
    private WebElement dateChoice;

    private final String XPATH_FOR_EMPTY_FORM_ERROR_MESSAGE = "//*[@id=\"formPesquisa\"]/div[2]/div";
    private WebElement emptySearchFormErrorMessage;

    private final String XPATH_FOR_DROPOFFTIME_BEFORE_PICKUPTIME_ERROR_MESSAGE = "//*[@id=\"DataDevolucao-error\"]";
    private WebElement dropOffTimeBeforePickUpTimeErrorMessage;

    private final String XPATH_PASSED_PICKUPTIME_ERROR_MESSAGE = "//*[@id=\"DataRetirada-error\"]";
    private WebElement passedPickUpTimeErrorMessage;

    private final String XPATH_EQUAL_PICKUP_AND_DROPOFF_TIME_ERROR_MESSAGE = "//*[@id=\"DataRetirada-error\"]";
    private WebElement equalPickUpAndDropOffTimeErrorMessage;


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public LoginPage redirectToLoginPage(){
        logInSignUpButton.click();
        return new LoginPage(driver);
    }

    public BookingPage redirectToBookingPage(){
        bookingButton.click();
        return new BookingPage(driver);
    }

    public LocationErrorPage inputLocationInformation(CarRentOptions rentTerms){
        defineTermsForCarLocationSearch(rentTerms);
        searchButton.click();
        return new LocationErrorPage(driver);
    }

    public UnavailablePickUpLocationErrorPage inputUnavailablePickUpLocation(CarRentOptions rentTerms){
        definePickUpLocationForCarSearch(rentTerms);
        searchButton.click();
        return new UnavailablePickUpLocationErrorPage(driver);
    }


    public PaymentPage selectCar(CarRentOptions rentTerms){
        defineTermsForCarSearch(rentTerms);
        searchButton.click();
        selectCarButton.click();
        return new PaymentPage(driver);
    }

    public void definePickUpLocationForCarSearch(CarRentOptions rentTerms){
        pickUpLocationInput.sendKeys(rentTerms.getPickUpLocation());
    }

    public void defineTermsForCarLocationSearch(CarRentOptions rentTerms){
        droppOffLocationCheck.click();
        dropOffLocationInput.sendKeys(rentTerms.getDropOffLocation());
        pickUpLocationInput.sendKeys(rentTerms.getPickUpLocation());
    }

    public String leaveSearchFormEmpty(CarRentOptions rentTerms){
        searchButton.click();
        emptySearchFormErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_EMPTY_FORM_ERROR_MESSAGE)));
        return emptySearchFormErrorMessage.getText();
    }

    public String checkEqualPickUpAndDropOffTime(CarRentOptions rentTerms){
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(rentTerms.getPickUpTime());
        dropOffDateInput.click();
        dateChoice.click();
        dropOffTimeInput.sendKeys(rentTerms.getDropOffTime());
        equalPickUpAndDropOffTimeErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_EQUAL_PICKUP_AND_DROPOFF_TIME_ERROR_MESSAGE)));
        return equalPickUpAndDropOffTimeErrorMessage.getText();
    }

    public String checkPickUpAndDropOffTime(CarRentOptions rentTerms){
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(rentTerms.getPickUpTime());
        dropOffDateInput.click();
        dateChoice.click();
        dropOffTimeInput.sendKeys(rentTerms.getDropOffTime());
        dropOffTimeBeforePickUpTimeErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_DROPOFFTIME_BEFORE_PICKUPTIME_ERROR_MESSAGE)));
        return dropOffTimeBeforePickUpTimeErrorMessage.getText();
    }

    public String checkPickUpTime(CarRentOptions rentTerms){
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(rentTerms.getPickUpTime());
        passedPickUpTimeErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_PASSED_PICKUPTIME_ERROR_MESSAGE)));
        return passedPickUpTimeErrorMessage.getText();
    }

    public void defineTermsForCarSearch(CarRentOptions rentTerms){
        pickUpLocationInput.sendKeys(rentTerms.getPickUpLocation());
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(rentTerms.getPickUpTime());
        dropOffDateInput.click();
        dateChoice.click();
        dropOffTimeInput.sendKeys(rentTerms.getDropOffTime());
    }

    public ClosedStoresErrorPage searchCarInClosedHours(CarRentOptions rentTerms){
        pickUpLocationInput.sendKeys(rentTerms.getPickUpLocation());
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(rentTerms.getPickUpTime());
        dropOffDateInput.click();
        dateChoice.click();
        dropOffTimeInput.sendKeys(rentTerms.getDropOffTime());
        searchButton.click();
        return new ClosedStoresErrorPage(driver);
    }
}
