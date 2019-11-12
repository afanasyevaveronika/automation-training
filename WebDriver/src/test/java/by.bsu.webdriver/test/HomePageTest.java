package by.bsu.webdriver.test;




import by.bsu.webdriver.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class HomePageTest {
    private WebDriver driver;
    private HomePage page;
    private final LocalDate pickUpDate = LocalDate.now();
    private final LocalTime timeNow = LocalTime.NOON;

    @BeforeClass
    public void browserSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        page = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void pickupAndReturnAtTheSameMomentImpossible() {
        page.inputPickUpLocation("Dresden Airport, Dresden, Germany-(DRS)" );
        page.inputPickUpDate(pickUpDate);
        page.inputReturnDate(pickUpDate);
        page.selectPickUpTime(timeNow.plusHours(1).minusMinutes(timeNow.getMinute()));
        page.selectReturnTime(timeNow.plusHours(1).minusMinutes(timeNow.getMinute()));
        page.selectCar();
        Assert.assertTrue(page.isErrorMessgaeVisiable());
    }

    @Test
    public void bookingInImpossibleLocation() {
        page.inputPickUpLocation("Kalinkovichi");
        page.inputPickUpDate(pickUpDate);
        page.selectPickUpTime(timeNow.plusHours(2).minusMinutes(timeNow.getMinute()));
        page.selectReturnTime(timeNow.plusHours(4).minusMinutes(timeNow.getMinute()));
        page.selectCar();
        Assert.assertTrue(page.isErrorMessgaeVisiable());
    }

    @AfterClass
    public void browserTearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}