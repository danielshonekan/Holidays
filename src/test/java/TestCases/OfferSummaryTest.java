package TestCases;

import config.DriverFactory;
import org.testng.annotations.Test;
import page.HomePage;
import page.Navbar;
import page.OfferSummaryPage;


public class OfferSummaryTest extends DriverFactory {

    private OfferSummaryPage offerSummaryPage ;
    private HomePage homePage ;
    Navbar navbar ;

    @Test
    public void searchForHoliday () {
        offerSummaryPage = new OfferSummaryPage(driver) ;
        homePage = new HomePage(driver) ;
        navbar = new Navbar(driver) ;

        offerSummaryPage.goToSummaryPage();
        navbar.closeNofication();
        navbar.clickHomePageButton();
        homePage.navigateToNewWindow();
        homePage.stillInterestedIsDisplayed();
        homePage.clickBookThisRoom();
        offerSummaryPage.isDisplayed() ;
        offerSummaryPage.offerSummaryPanelIsDislayed();
    }
}
