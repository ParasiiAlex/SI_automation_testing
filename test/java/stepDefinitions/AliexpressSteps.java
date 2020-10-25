package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AliexpressSteps {

    WebDriver driver;

    @Given("I launch Chrome browser and open aliexpress.com page")
    public void i_launch_chrome_browser_and_open_aliexpress_com_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://best.aliexpress.com/");
    }

    @When("I make a search for computer")
    public void i_make_a_search_for_computer() {
        driver.findElement(By.id("search-key")).sendKeys("computers");
    }

    @Then("I check the header of page")
    public void i_check_the_header_of_page() {
        boolean status;
        status = driver.findElement(By.className("logo-base")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
    }
}
