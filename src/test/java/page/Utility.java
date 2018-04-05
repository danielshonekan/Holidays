package page;

import config.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class Utility {

    private static final CharSequence URL = null;

    WebDriver driver ;

    public Utility(WebDriver driver) {
        this.driver = driver ;
    }

    public void click(By element){
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public boolean elementPresent(By element){
        if (driver.findElements(element).size()>0){
            try {
                if (driver.findElement(element).isDisplayed()) {
                    return true;
                }
            }
            catch(Exception e) {
                return false;
            }
        }
        return false;
    }

    public void clickFromList (By element, int increment)  {
        List<WebElement> menuOption = driver.findElements(element);
        WaitAndClickElement(menuOption.get(increment));
    }


    public void WaitAndClickElement ( WebElement element) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String   getTextFromList (By element, int increment) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(element)) ;
        List <WebElement> menu =  driver.findElements(element) ;
        String text = menu.get(increment).getText() ;
        return text ;
    }

    public void sleep(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String username)  {
        String data = new PropertyReader().readProperty(username) ;
        return data ;
    }

    public boolean isDisplayed () {
      return driver.getCurrentUrl().contains(URL)  ;
    }

    public void waitUntilElementIsVisible (By element) {
        new WebDriverWait(driver, 30).until
                (ExpectedConditions.presenceOfAllElementsLocatedBy(element)) ;
    }


}
