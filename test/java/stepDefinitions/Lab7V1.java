package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Lab7V1 {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open google.com page")
    public void i_open_google_co_page() {
        driver.get("https://www.google.com");
    }

    @Then("I check for google logo")
    public void i_check_for_google_logo() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@alt=\"Google\"]")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I enter a text for search")
    public void i_enter_a_text_for_search() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[2]/input")).sendKeys("school");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]")).submit();
    }

    @Then("I check the number of results on a single page")
    public void i_check_the_number_of_results_on_a_single_page() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(expectation);

        int count;
        count = driver.findElements(By.xpath("//*[@id=\"rso\"]/div")).size();

        Assert.assertNotEquals(0, count);
    }

    @When("I enter nothing and click search button")
    public void i_enter_nothing_and_click_search_button() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[2]/input")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]")).submit();
    }

    @Then("I see no changes")
    public void i_see_no_changes() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"tsf\"]")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I search for irrelevant keyword")
    public void i_search_for_irrelevant_keyword() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[2]/input")).sendKeys("hellow world");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]")).submit();
    }

    @Then("I check for Did you mean link")
    public void i_check_for_did_you_mean_link() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"fprs\"]")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I close the page and browser")
    public void i_close_the_page_and_browser() {
        driver.quit();
    }

}
