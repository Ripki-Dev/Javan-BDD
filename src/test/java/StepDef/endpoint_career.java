package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class endpoint_career {
    WebDriver driver;
    public static String URL = "https://javan.co.id";
    public void openWeb(String path){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL+path);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void quitWeb(){
        driver.close();
        driver.quit();
    }
    @Given("User go to path career {string}")
    public void userGoToPathCareer(String path) {
        openWeb(path);
    }

    @And("User click career, for example {string}")
    public void userClickCareerForExample(String name) {
        driver.findElement(By.linkText(name)).click();
    }

    @And("User redirect to {string} career page")
    public void userRedirectToCareerPage(String careerName) {
        Assert.assertEquals(driver.findElement(By.cssSelector("a[class='font-nunito font-extrabold text-2xl text-primary']")).getText(), careerName);
    }

    @When("User change career endpoint to {string}")
    public void userChangeCareerEndpointTo(String endpointNumb) {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        System.out.println(url.length());
        url = url.substring(0, url.length()-2);
        System.out.println(url+endpointNumb);
        driver.get(url+endpointNumb);
    }

    @Then("User will see {string} career page with invalid current endpoint")
    public void userWillSeeCareerPageWithInvalidCurrentEndpoint(String careerName) {
        Assert.assertEquals(driver.findElement(By.cssSelector("a[class='font-nunito font-extrabold text-2xl text-primary']")).getText(), careerName);
        quitWeb();
    }
}
