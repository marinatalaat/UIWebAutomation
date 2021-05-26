import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    private WebDriver driver;
    private String BrokenImageLink = "//a[text()='Broken Images']";
    private String BrokenImageHeader = "//h3[text()='Broken Images']";

    private String BasicAuthLink = "//a[text()='Basic Auth']";

    WebDriverWait wait;



    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @Step("navigateToBrokenImagePage")
    public BrokenImaggesPage navigateToBrokenImagePage(){
        driver.findElement(BaseActions.returnElementLocatorBy(BrokenImageLink, BaseActions.Locators.XPATH)).click();
        BaseActions.waitUntil(driver, BaseActions.returnElementLocatorBy(BrokenImageHeader, BaseActions.Locators.XPATH)
                ,BaseActions.ExpectedConditionsEnum.Visible);
        return new BrokenImaggesPage(driver);
    }

    @Step("navigateToBasicAuthPage")
    public BasicAuthPage navigateToBasicAuthPage(String name, String password){
        driver.findElement(BaseActions.returnElementLocatorBy(BasicAuthLink, BaseActions.Locators.XPATH)).click();
        // https://username:password@the-internet.herokuapp.com/basic_auth
        driver.get("https://"+name+":"+password+"@the-internet.herokuapp.com/basic_auth");
        return new BasicAuthPage(driver);
    }
}
