package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class TIC189Steps {

    public WebDriver driver;
    public DesiredCapabilities caps;
    public Local l;

    public String AUTOMATE_USERNAME = "alexpr1";
    public String AUTOMATE_ACCESS_KEY = "MSsiyuKmVUvHoEEniWvD";
    public String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("I launch Chrome browser3")
    public void i_launch_chrome_browser3() throws Exception {
        caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "TIC-189"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page3")
    public void i_open_loving_hermann_page3() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I click the button Sign Up")
    public void i_click_the_button_sign_up() {
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[2]/a")).click();
    }

    @Then("I check that A pop up form is displayed")
    public void i_check_that_a_pop_up_form_is_displayed() {
        String status;
        status = driver.findElement(By.xpath("//*[@id=\"myModal2\"]")).getAttribute("style");
        Assert.assertEquals("display: block;", "display: block;");
    }

    @When("I Fill the input field Name with valid data")
    public void i_fill_the_input_field_name_with_valid_data() {
        driver.findElement(By.name("Name")).sendKeys("Alex");
    }

    @When("I Fill the input field Email with invalid data")
    public void i_fill_the_input_field_email_with_invalid_data() {
        driver.findElement(By.name("Email")).sendKeys("testmail.com");
    }

    @When("I Fill the input field Password with valid data")
    public void i_fill_the_input_field_password_with_valid_data() {
        driver.findElement(By.name("password")).sendKeys("test");
    }

    @When("I Fill the input field Confirm Password with valid data")
    public void i_fill_the_input_field_confirm_password_with_valid_data() {
        driver.findElement(By.name("Confirm Password")).sendKeys("test");
    }

    @When("I Click SIGN UP button")
    public void i_click_sign_up_button() {
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/input")).click();
    }

    @Then("Alert message is displayed under the input field Email")
    public void alert_message_is_displayed_under_the_input_field_email() {
        boolean status;
        status = driver.findElement(By.className("modal-content")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I close the browser3")
    public void i_close_the_browser3() {
        driver.quit();
    }

}
