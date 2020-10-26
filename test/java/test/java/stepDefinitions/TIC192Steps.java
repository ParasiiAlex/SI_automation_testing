package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TIC192Steps {

    WebDriver driver;

    @Given("I launch Chrome browser6")
    public void i_launch_chrome_browser6() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page6")
    public void i_open_loving_hermann_page6() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("Click on the tab Contact")
    public void click_on_the_tab_contact() {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")).click();
    }

    @Then("I check that A contact form is present")
    public void i_check_that_a_contact_form_is_present() {
        boolean status;
        status = driver.findElement(By.className("contact-form")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I Fill the input field Name with valid data4")
    public void i_fill_the_input_field_name_with_valid_data4() {
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[1]/input")).sendKeys("Alex");
    }

    @When("I Fill the input field Email with valid data4")
    public void i_fill_the_input_field_email_with_valid_data4() {
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[2]/input")).sendKeys("Alex@mail.ru");
    }

    @When("I Fill the input field Subject with a valid data")
    public void i_fill_the_input_field_subject_with_a_valid_data() {
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[3]/input")).sendKeys("Help");
    }

    @When("I Fill the input field Message with a valid data")
    public void i_fill_the_input_field_message_with_a_valid_data() {
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/div[4]/textarea")).sendKeys("A lot of bugs here");
    }

    @When("I Click SEBD button")
    public void i_click_sebd_button() {
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/div[2]/form/input")).click();
    }

    @Then("I check for A notification on the top of webpage")
    public void i_check_for_a_notification_on_the_top_of_webpage() {
        boolean status;
        status = driver.findElement(By.className("alert")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I close the browser6")
    public void i_close_the_browser6() {
        driver.close();
    }

}
