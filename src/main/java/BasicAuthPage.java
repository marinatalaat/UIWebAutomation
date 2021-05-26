import org.openqa.selenium.WebDriver;

public class BasicAuthPage {

    private WebDriver driver;
    private String BasicAuthHeader = "//p[contains(text(),'Congratulations! You must have the proper credentials.')]";

    public BasicAuthPage(WebDriver driver){
        this.driver = driver;
    }


    public String checkPageHeader(){
        return driver.findElement(BaseActions.returnElementLocatorBy(BasicAuthHeader, BaseActions.Locators.XPATH)).getText();
    }

}
