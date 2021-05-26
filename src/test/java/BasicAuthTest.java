import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAuthTest {

    WebDriver driver;
    Base base = new Base();
    HomePage homePage;

    @BeforeTest
    public void SetUp(){
        base.browserSetUp(Base.Driver_Type.Chrome);
        driver = base.navigateToUrl("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @Test(priority = 1, description = "verify the Basic Auth")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description is to verify the Basic Auth")
    @Story("Check Basic Auth Story")
    public void BasicAuthTest() {
        BasicAuthPage basicAuthPage = homePage.navigateToBasicAuthPage("admin","admin");
        String header = basicAuthPage.checkPageHeader();
        System.out.println(header);
        Assert.assertTrue(header.contains("Congratulations"),"wrong header");
    }
}
