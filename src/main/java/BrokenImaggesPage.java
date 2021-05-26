import io.qameta.allure.Step;
import org.apache.http.client.HttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.IOException;
import java.util.List;

public class BrokenImaggesPage {

    private WebDriver driver;
    private String imagesTag = "//img";
    int countOfBrokenImages;

    public BrokenImaggesPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("countOfBrokenImages")
    public int countOfBrokenImages(){
        countOfBrokenImages = 0;

        List<WebElement> images = driver.findElements(BaseActions.returnElementLocatorBy(imagesTag, BaseActions.Locators.XPATH));
        for (WebElement image : images){
            if (image != null){
                countOfBrokenImages+=checkImage(image);
            }

        }
        return countOfBrokenImages;
    }


    @Step("checkImageFunction")
    public int checkImage(WebElement image){
        int count = 0;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(image.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if(response.getStatusLine().getStatusCode() != 200){
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
