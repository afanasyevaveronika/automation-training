package by.bsu.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton
{
    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.by.bsu.framework.driver", "src\\test\\resources\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver = null;
        webDriver.close();
    }
}