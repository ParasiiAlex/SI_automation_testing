package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


public class TIC193Steps {

    public WebDriver driver;
    public DesiredCapabilities caps;
    public Local l;

    public String AUTOMATE_USERNAME = "alexpr1";
    public String AUTOMATE_ACCESS_KEY = "MSsiyuKmVUvHoEEniWvD";
    public String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("I launch Chrome browser7")
    public void i_launch_chrome_browser7() throws Exception {
        caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "TIC-193"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page7")
    public void i_open_loving_hermann_page7() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I Scroll down till New Arrival section")
    public void i_scroll_down_till_new_arrival_section() {

    }

    @Then("I check that New Arrival section exists")
    public void i_check_that_new_arrival_section_exists() {
        boolean status;
        status = driver.findElement(By.className("new_arrivals_agile_w3ls_info")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I Click ADD TO CART button")
    public void i_click_add_to_cart_button() {
        driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div/div[1]/div[1]/div/div[2]/div[2]/form/fieldset/input[10]")).click();
    }

    @Then("I check that In the cart list has appeared selected product")
    public void i_check_that_in_the_cart_list_has_appeared_selected_product() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[1]/a")).isEnabled();
        Assert.assertTrue(status);

        String value;
        value = driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[2]/input")).getAttribute("value");
        Assert.assertEquals("1", value);
    }

    @When("I Modify the quantity of the second product from the cart from {int} to {int}")
    public void i_modify_the_quantity_of_the_second_product_from_the_cart_from_to(Integer int1, Integer int2) {
        driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[2]/input")).sendKeys(int2.toString());
    }

    @Then("I check that The Price of the product is raised")
    public void i_check_that_the_price_of_the_product_is_raised() {
        WebDriverWait wait = new WebDriverWait(driver,1);
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"PPMiniCart\"]/form/ul/li/div[4]/span"), "$459.90"));
    }

    @Then("I close the browser7")
    public void i_close_the_browser7() {
        driver.quit();
    }

}
