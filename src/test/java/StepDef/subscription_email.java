package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class subscription_email {
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
    @Given("User go to path home {string}")
    public void userGoToPathHome(String path) {
       openWeb(path);
    }

    @And("User scroll page until down")
    public void userScrollPageUntilDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emailField = driver.findElement(By.cssSelector("input[class='w-full h-8 sm:h-8 px-4 py-2 text-sm text-indigo-800 rounded-md focus:outline-none']"));
        js.executeScript("arguments[0].scrollIntoView();", emailField);
    }

    @When("User fill in field email subscription {string}")
    public void userFillInFieldEmailSubscription(String email) {
        driver.findElement(By.cssSelector("input[class='w-full h-8 sm:h-8 px-4 py-2 text-sm text-indigo-800 rounded-md focus:outline-none']")).sendKeys(email);
    }

    @Then("User click button subscribe")
    public void userClickButtonSubscribe() {
        driver.findElement(By.cssSelector("button[class='inline-flex items-center h-8 px-2 text-base font-bold leading-6 text-white transition duration-150 ease-in-out bg-blue-600 border border-transparent rounded-md hover:bg-indigo-700 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700 ajaxsubscribe']")).click();
    }

    @And("validate success message")
    public void validateSuccessMessage() {
        Assert.assertEquals(driver.findElement(By.className("swal2-title")).getText(), "Submit email success");
        quitWeb();
    }
}
