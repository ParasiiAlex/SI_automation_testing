package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TIC190Steps {

    WebDriver driver;

    @Given("I launch Chrome browser4")
    public void i_launch_chrome_browser4() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page4")
    public void i_open_loving_hermann_page4() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I click the button Sign Up2")
    public void i_click_the_button_sign_up2() {
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[2]/a")).click();
    }

    @Then("I check that A pop up form is displayed2")
    public void i_check_that_a_pop_up_form_is_displayed2() {
        String status;
        status = driver.findElement(By.xpath("//*[@id=\"myModal2\"]")).getAttribute("style");
        Assert.assertEquals("display: block;", "display: block;");
    }

    @When("I Fill the input field Name with valid data2")
    public void i_fill_the_input_field_name_with_valid_data2() {
        driver.findElement(By.name("Name")).sendKeys("Alex");
    }

    @When("I Fill the input field Email with valid data")
    public void i_fill_the_input_field_email_with_valid_data() {
        driver.findElement(By.name("Email")).sendKeys("test@mail.com");
    }

    @When("I Fill the input field Password with valid data2")
    public void i_fill_the_input_field_password_with_valid_data2() {
        driver.findElement(By.name("password")).sendKeys("test");
    }

    @When("I Fill the input field Confirm Password with valid data2")
    public void i_fill_the_input_field_confirm_password_with_valid_data2() {
        driver.findElement(By.name("Confirm Password")).sendKeys("test");
    }

    @When("I Click SIGN UP button2")
    public void i_click_sign_up_button2() {
        driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[2]/div[1]/form/input")).click();
    }

    @Then("I am redirected to home page")
    public void i_am_redirected_to_home_page() {
        String url;
        url = driver.getCurrentUrl();
        Assert.assertEquals("https://loving-hermann-e2094b.netlify.app/index.html", url);
    }

    @When("I am looking for Sign In Button")
    public void i_am_looking_for_sign_in_button() {

    }

    @Then("Sign In button is not present")
    public void sign_in_button_is_not_present() {
        boolean status;
        status = driver.findElement(By.xpath("//*[@id=\"home\"]/div/ul/li[1]")).isDisplayed();
        Assert.assertFalse(status);
    }

    @Then("I close the browser4")
    public void i_close_the_browser4() {
        driver.close();
    }

}
