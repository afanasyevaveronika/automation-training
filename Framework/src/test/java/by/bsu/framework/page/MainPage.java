package by.bsu.framework.page;

import by.bsu.framework.model.CarRenting;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.LocalTime;

import static by.bsu.framework.service.CarRentingCreator.DATA_FORMATTER;
import static by.bsu.framework.service.CarRentingCreator.TIME_FORMATTER;


public class MainPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(MainPage.class);
    private final String MainPage_URL = "https://www.avis.com/";

    @FindBy(xpath = "//input[@id='PicLoc_value']")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//input[@id='DropLoc_value']")
    private WebElement returnLocation;

    @FindBy(xpath = "//input[@id='from']")
    private WebElement pickUpDate;

    @FindBy(xpath = "//select[@name='reservationModel.pickUpTime' and @class='form-control res-inputTime ng-pristine ng-valid ng-not-empty optFromTime ng-touched']")
    private WebElement pickUpTime;

    @FindBy(xpath = "//input[@id='to']")
    private WebElement returnDate;

    @FindBy(xpath = "//select[@name='reservationModel.dropTime' and @class='form-control res-inputTime ng-pristine ng-valid ng-not-empty optToTime ng-touched']")
    private WebElement returnTime;

    @FindBy(xpath = "//button[@id='res-home-select-car']")
    private WebElement selectCar;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(MainPage_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.log(Level.INFO, "Home by.bsu.framework.page opened");
        return this;
    }

    public MainPage inputPickUpLocation(String picLoc) {
        pickUpLocation.sendKeys(picLoc);
        pickUpLocation.sendKeys(picLoc);
        return this;
    }

    public MainPage inputReturnLocation(String returnLoc) {
        returnLocation.sendKeys(returnLoc);
        return this;
    }

    public MainPage inputPickUpDate(LocalDate picDate) {
        pickUpDate.clear();
        pickUpDate.sendKeys(picDate.format(DATA_FORMATTER));
        return this;
    }

    public MainPage inputReturnDate(LocalDate dropDate) {
        returnDate.clear();
        returnDate.sendKeys(dropDate.format(DATA_FORMATTER));
        return this;
    }

    public MainPage selectCar() {
        selectCar.click();
        return this;
    }

    public MainPage selectPickUpTime(LocalTime picTime) {
        new Select(pickUpTime).selectByVisibleText(picTime.format(TIME_FORMATTER));
        return this;
    }

    public MainPage selectReturnTime(LocalTime dropTime) {
        new Select(returnTime).selectByVisibleText(dropTime.format(TIME_FORMATTER));
        return this;
    }

    public String getErrorMessage() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//div[@class='col-lg-12 res-PageError']//span[@class='mainErrorText info-error-msg-text']")))
                .getText();
    }

    public VehiclePage carRenting(CarRenting carRenting) {
        inputPickUpLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow().plusDays(1))
                .inputReturnDate(carRenting.getDateNow().plusDays(2))
                .selectCar();
        logger.log(Level.INFO, "Vehicle by.bsu.framework.page performed.");
        return new VehiclePage(driver);
    }
}