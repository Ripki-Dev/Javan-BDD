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

public class endpoint_portfolio {
    WebDriver driver;
    public static String URL = "https://javan.co.id";
    public void openWeb(String path){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL+path);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void quitWeb(){
        driver.close();
        driver.quit();
    }
    @Given("User go to path portfolio {string}")
    public void userGoToPathPortfolio(String path) {
        openWeb(path);
    }

    @And("User click portfolio, for example {string}")
    public void userClickPortfolioForExample(String title) {
        driver.findElement(By.linkText(title)).click();
    }

    @And("User redirect to {string} portfolio page")
    public void userRedirectToPortfolioPage(String nameProject) {
        Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='font-nunito font-extrabold text-center sm:text-left text-lg lg:text-4xl text-primary'] span[class='leading-tight']")).getText(), nameProject);
    }

    @When("User change endpoint to {string}")
    public void userChangeEndpointTo(String endpointNumb) {
        String url = driver.getCurrentUrl();
        System.out.println(url);
        System.out.println(url.length());
        url = url.substring(0, url.length()-2);
        System.out.println(url+endpointNumb);
        driver.get(url+endpointNumb);
    }

    @Then("User will see PLN Project portfolio page with invalid current endpoint")
    public void userWillSeePLNProjectPortfolioPageWithInvalidCurrentEndpoint() {
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class='leading-tight']")).getText(), "CR Aplikasi SIMLOAN");
        quitWeb();
    }
}
