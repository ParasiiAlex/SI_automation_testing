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


public class TIC189Steps {

    WebDriver driver;

    @Given("I launch Chrome browser3")
    public void i_launch_chrome_browser3() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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
