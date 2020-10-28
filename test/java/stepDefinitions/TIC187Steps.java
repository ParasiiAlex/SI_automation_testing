package stepDefinitions;

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

public class TIC187Steps {

    public WebDriver driver;
    public DesiredCapabilities caps;
    public Local l;

    public String AUTOMATE_USERNAME = "alexpr1";
    public String AUTOMATE_ACCESS_KEY = "MSsiyuKmVUvHoEEniWvD";
    public String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("I launch Chrome browser")
    public void i_launch_chrome_browser() throws Exception {
        caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "TIC-187"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page")
    public void i_open_loving_hermann_page() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I click on the input intended for searching products")
    public void i_click_on_the_input_intended_for_searching_products() {
        boolean status;
        status = driver.findElement(By.name("search")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("Fill the input with a real product name")
    public void fill_the_input_with_a_real_product_name() {
        driver.findElement(By.name("search")).sendKeys("Analog Watch");
    }

    @Then("I check the input is containing entered text")
    public void i_check_the_input_is_containing_entered_text() {
        String text;
        text = driver.findElement(By.name("search")).getAttribute("value");
        Assert.assertEquals("Analog Watch", text);
    }

    @When("I click on the Search button")
    public void i_click_on_the_search_button() {
        driver.findElement(By.xpath("//form")).submit();
    }

    @Then("I am redirected to a page containing a list of products")
    public void i_am_redirected_to_a_page_containing_a_list_of_products() {
        boolean status;
        status = driver.findElement(By.name("product-list")).isDisplayed();
        Assert.assertTrue(status);
    }

}
