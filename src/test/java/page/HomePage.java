package page;

import config.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class HomePage extends Utility {

    public HomePage (WebDriver driver) {
        super(driver);
    }


    private static final By STILL_INTERESTED_HEADER = By.cssSelector("h2.return-to-offer-large__title") ;
    private static final By BOOK_THIS_ROOM = By.cssSelector("a[href*='/book/flight-and-hotel/offer']") ;






    public void navigateToNewWindow () {
        Set <String> set1 = driver.getWindowHandles() ;
        Iterator <String> win1= set1.iterator() ;
        String parent = win1.next() ;
        String child = win1.next() ;
        driver.switchTo().window(child) ;
    }

    public void stillInterestedIsDisplayed () {
        waitUntilElementIsVisible(STILL_INTERESTED_HEADER);
        Assert.assertTrue(elementPresent(STILL_INTERESTED_HEADER));
    }

    public void clickBookThisRoom () {
        click(BOOK_THIS_ROOM);
    }


}
