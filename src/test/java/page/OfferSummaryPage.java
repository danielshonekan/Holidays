package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Wale on 04/04/2018.
 */
public class OfferSummaryPage extends Utility {

    public OfferSummaryPage (WebDriver driver) {
        super(driver);
    }

    private static String OFFER_PAGE_URL = "www.loveholidays.com/book/flight-and-hotel/offer-summary.html" ;
    private static final By OFFER_SUMMARY_PANEL = By.cssSelector("div.book-offer-summary-select-room") ;


    public boolean isDisplayed () {
        if (driver.getCurrentUrl().contains(OFFER_PAGE_URL))  {
            return true ;

        } else return false ;
    }


    public void goToSummaryPage () {
        driver.navigate().to(getProperty("offer.url"));
        driver.manage().window().maximize();
    }


    public void offerSummaryPanelIsDislayed () {
        waitUntilElementIsVisible(OFFER_SUMMARY_PANEL);
        Assert.assertTrue(elementPresent(OFFER_SUMMARY_PANEL));
    }


}
