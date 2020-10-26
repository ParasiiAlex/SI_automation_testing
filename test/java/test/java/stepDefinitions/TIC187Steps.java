package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TIC187Steps {

    WebDriver driver;

    @Given("I launch Chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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
