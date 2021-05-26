import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {

    /**
     * @param selector = path of Element
     * @param locator = Type Of Locator
     * @return By Object
     *
     */

    public static By returnElementLocatorBy(String selector, Locators locator){
        switch (locator){
            case XPATH:
                return new By.ByXPath(selector);
            case ID:
                return new By.ById(selector);
            case CSS:
                return new By.ByCssSelector(selector);
            default:
                return null;
        }

    }


    public enum Locators{
        XPATH, ID,CSS
    }


    public static WebElement waitUntil (WebDriver driver, By by, ExpectedConditionsEnum condition){
        try {
            WebElement element ;
            switch (condition) {
                case Presence:
                    element = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
                    return element;

                case Clickable:
                    element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
                    return element;
                case Visible:
                    element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
                    return element;

                default:
                    element = null;
                    System.out.println("Could not Find the Element");
            }
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public enum ExpectedConditionsEnum{
        Presence, Visible, Clickable
    }
}
