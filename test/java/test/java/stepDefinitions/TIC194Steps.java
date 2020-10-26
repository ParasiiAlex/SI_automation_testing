package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TIC194Steps {

    WebDriver driver;

    @Given("I launch Chrome browser8")
    public void i_launch_chrome_browser8() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page8")
    public void i_open_loving_hermann_page8() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I Click on the Men's wear button")
    public void i_click_on_the_men_s_wear_button() {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }

    @Then("I check that A pop-up should appear with two links")
    public void i_check_that_a_pop_up_should_appear_with_two_links() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/ul/div/div[2]/ul/li/a")).isEnabled();
        Assert.assertTrue(status);
    }

    @When("I Click on the Clothing link")
    public void i_click_on_the_clothing_link() {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/ul/div/div[2]/ul/li/a")).click();
    }

    @Then("I check that User should be redirected to page mens.html")
    public void i_check_that_user_should_be_redirected_to_page_mens_html() {
        String url;
        url = driver.getCurrentUrl();
        Assert.assertEquals("https://loving-hermann-e2094b.netlify.app/mens.html", url);
    }

    @When("I Select sorting method Name AZ")
    public void i_select_sorting_method_name_az() {
        Select sorting = new Select(driver.findElement(By.xpath("//*[@id=\"country1\"]")));
        sorting.selectByIndex(0);
    }

    @Then("I check that Products should be ordered by name fromA to Z")
    public void i_check_that_products_should_be_ordered_by_name_from_a_to_z() {
        String title;
        title = driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div[2]/div/div[2]/h4/a")).getText();
        Assert.assertEquals("Analog Watch", title);
    }

    @When("I Select sorting method Name ZA")
    public void i_select_sorting_method_name_za() {
        Select sorting = new Select(driver.findElement(By.xpath("//*[@id=\"country1\"]")));
        sorting.selectByIndex(2);
    }

    @Then("I check that Products should be ordered by name fromZ to A")
    public void i_check_that_products_should_be_ordered_by_name_from_z_to_a() {
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[7]/div/div[4]/div[3]/div/div[2]/h4/a"), "Running Shoes"));
    }

    @Then("I close the browser8")
    public void i_close_the_browser8() {
        driver.close();
    }

}
