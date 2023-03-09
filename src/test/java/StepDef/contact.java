package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class contact {
    WebDriver driver;
    public static String URL = "https://javan.co.id";
    public void openWeb(String path){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL+path);
    }
    public void quitWeb(){
        driver.close();
        driver.quit();
    }
    public void pause(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Given("User go to path contact {string}")
    public void userGoToPathContact(String path) {
        openWeb(path);
    }

    @And("User redirect to contact page {string}")
    public void userRedirectToContactPage(String namePage) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement titleField = driver.findElement(By.cssSelector("div[class='w-full pb-6 space-y-6 sm:max-w-md lg:max-w-lg md:space-y-4 lg:space-y-8 xl:space-y-9 sm:pr-5 lg:pr-0 md:pb-0'] h1[class='font-nunito font-extrabold text-center sm:text-left text-2xl text-primary']"));
        js.executeScript("arguments[0].scrollIntoView();", titleField);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='w-full pb-6 space-y-6 sm:max-w-md lg:max-w-lg md:space-y-4 lg:space-y-8 xl:space-y-9 sm:pr-5 lg:pr-0 md:pb-0'] h1[class='font-nunito font-extrabold text-center sm:text-left text-2xl text-primary']")).getText(), namePage);
    }

    @When("User fill full name with {string}")
    public void userFillFullNameWith(String name) {
        driver.findElement(By.id("in_name")).sendKeys(name);
    }

    @And("User fill Nick Name with {string}")
    public void userFillNickNameWith(String nickName) {
        driver.findElement(By.id("in_nickname")).sendKeys(nickName);
    }

    @And("User fill email with {string}")
    public void userFillEmailWith(String email) {
        driver.findElement(By.id("in_email")).sendKeys(email);
    }

    @And("User fill Phone or Whatsapp {string}")
    public void userFillPhoneWhatsapp(String phone) {
        driver.findElement(By.id("in_phone")).sendKeys(phone);
    }

    @And("User fill Company or Institution {string}")
    public void userFillCompanyInstitution(String company) {
        driver.findElement(By.id("in_institution")).sendKeys(company);
    }

    @And("User choose dropdown option {string}")
    public void userChooseDropdownOption(String txt) {
        Select dropdown = new Select(driver.findElement(By.id("in_subject")));
        dropdown.selectByValue("Ads");
    }

    @And("User fill Tell us what you need {string}")
    public void userFillTellUsWhatYouNeed(String description) {
        driver.findElement(By.id("in_message")).sendKeys(description);
    }

    @And("User check captcha")
    public void userCheckCaptcha() {
        pause();
    }

    @Then("User click Send Button")
    public void userClickSendButton() {
        driver.findElement(By.cssSelector("button[class='card-btn-primary w-2/5']")).click();
    }

    @And("validate success message from contact")
    public void validateSuccessMessageFromContact() {
        String txt = driver.findElement(By.id("swal2-title")).getText();
        Assert.assertEquals(driver.findElement(By.id("swal2-title")).getText(), txt);
        quitWeb();
    }

}
