package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Wale on 04/04/2018.
 */
public class Navbar extends Utility {

    public Navbar (WebDriver driver) {
        super(driver);
    }

    private static final By HOME_PAGE_BUTTON = By.cssSelector("a.book-header-nav-bar__list__item__link") ;
    private static final By HEADER_NOTIFICATION = By.cssSelector("a.notifications-layout__close") ;


    public void clickHomePageButton () {
       waitUntilElementIsVisible(HOME_PAGE_BUTTON);
        clickFromList(HOME_PAGE_BUTTON, 0);
    }

    public void closeNofication () {
         waitUntilElementIsVisible(HEADER_NOTIFICATION);
         click(HEADER_NOTIFICATION);

    }
}
