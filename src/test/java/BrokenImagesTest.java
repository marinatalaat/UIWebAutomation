import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenImagesTest {

    WebDriver driver;
    Base base = new Base();
    HomePage homePage;

    @BeforeTest
    public void SetUp(){
        base.browserSetUp(Base.Driver_Type.Chrome);
        driver = base.navigateToUrl("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @Test(priority = 1, description = "verify the images on Broken Images page")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description is to verify the images on Broken Images page")
    @Story("Check Images Story")
    public void BrokenImagesTest(){
        BrokenImaggesPage brokenImaggesPage = homePage.navigateToBrokenImagePage();
        int count = brokenImaggesPage.countOfBrokenImages();

        System.out.println(count);
        Assert.assertEquals(count, 2,"wrong number");
    }
}
