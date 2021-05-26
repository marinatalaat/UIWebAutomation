import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    static WebDriver driver;


    public void browserSetUp(Driver_Type driverType){

        switch (driverType){
            case FireFox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case Chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case IE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
        }
    }

    public WebDriver navigateToUrl(String url){
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;
    }

    public void TearDown(){
        driver.quit();
    }

    public enum Driver_Type{
        FireFox, Chrome, IE
    }
}
