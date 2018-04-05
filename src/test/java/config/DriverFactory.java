package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Wale on 04/04/2018.
 */
public class DriverFactory {

    public static WebDriver driver = null ;
    String browser = new PropertyReader().readProperty("browser");

    @BeforeSuite
    public void setUp () {

        if (browser.contains("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver",  "");
            driver = new ChromeDriver();


        } else if (browser.contains("ie")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver() ;
        }

    }

    @AfterSuite
    public void tearDown () {
        driver.close();
    }

}
