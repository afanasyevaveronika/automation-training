package by.bsu.framework.page;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclePage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(MainPage.class);
    private final String VEHICLE_PAGE_URL = "https://www.avis.com/en/reservation#/vehicles";

    public VehiclePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@id='vehicleTeaser']//div[@class='location-info']")
    private WebElement pickUpLocationInfo;


    @Override
    public AbstractPage openPage() {
        driver.navigate().to(VEHICLE_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.log(Level.INFO, "Vehicle by.bsu.framework.page opened");
        return this;
    }

    public String pickUpLocationInfo() {
        return pickUpLocationInfo.getText();
    }


}
