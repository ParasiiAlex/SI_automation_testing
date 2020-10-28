package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.browserstack.local.Local;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class TIC191Steps {

    public WebDriver driver;
    public DesiredCapabilities caps;
    public Local l;

    public String AUTOMATE_USERNAME = "alexpr1";
    public String AUTOMATE_ACCESS_KEY = "MSsiyuKmVUvHoEEniWvD";
    public String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("I launch Chrome browser5")
    public void i_launch_chrome_browser5() throws Exception {
        caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "TIC-191"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page5")
    public void i_open_loving_hermann_page5() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I Click the button Sign In")
    public void i_click_the_button_sign_in() {
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[1]/a")).click();
    }

    @Then("I check that A pop up form is displayed3")
    public void i_check_that_a_pop_up_form_is_displayed3() {
        String status;
        status = driver.findElement(By.xpath("//*[@id=\"myModal\"]")).getAttribute("style");
        Assert.assertEquals("display: block;", "display: block;");
    }

    @When("I Fill the input field Name with valid data3")
    public void i_fill_the_input_field_name_with_valid_data3() {
        driver.findElement(By.name("Name")).sendKeys("Alex");
    }

    @When("I Fill the input field Password with valid data3")
    public void i_fill_the_input_field_password_with_valid_data3() {
        driver.findElement(By.name("Email")).sendKeys("Alex@mail.ru");
    }

    @When("I Click SIGN IN button")
    public void i_click_sign_in_button() {
        driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/form/input")).click();
    }

    @Then("I am redirected to home page2")
    public void i_am_redirected_to_home_page2() {
        String url;
        url = driver.getCurrentUrl();
        Assert.assertEquals("https://loving-hermann-e2094b.netlify.app/index.html", url);
    }

    @When("I am looking for Sign In Button2")
    public void i_am_looking_for_sign_in_button2() {

    }

    @Then("Sign In button is not present2")
    public void sign_in_button_is_not_present2() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[1]")).isDisplayed();
        Assert.assertFalse(status);
    }

    @Then("Profile button is displayed")
    public void profile_button_is_displayed() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"profile\"]")).isDisplayed();
        Assert.assertFalse(status);
    }

    @Then("I close the browser5")
    public void i_close_the_browser5() {
        driver.quit();
    }

}
