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

import java.util.concurrent.TimeUnit;


public class TIC188Steps {

    WebDriver driver;

    @Given("I launch Chrome browser2")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I open loving-hermann page2")
    public void i_open_loving_hermann_page() {
        driver.get("https://loving-hermann-e2094b.netlify.app/");
    }

    @When("I scroll down till the section New Arrivals")
    public void i_scroll_down_till_the_section_new_arrivals() {
        boolean status;
        status = driver.findElement(By.className("new_arrivals_agile_w3ls_info")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I hover the image of an product from section New Arrival")
    public void i_hover_the_image_of_an_product_from_section_new_arrival() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.className("men-thumb-item"));
        action.moveToElement(element).perform();
    }

    @Then("I check that black button Quick View is displayed")
    public void i_check_that_black_button_quick_view_is_displayed() {
        boolean status;
        status = driver.findElement(By.className("link-product-add-cart")).isDisplayed();
        Assert.assertTrue(status);
    }

    @When("I click the button Quick View")
    public void i_click_the_button_quick_view() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.className("link-product-add-cart"));
        action.moveToElement(element).click();
    }

    @Then("I am redirected to another page that presents selected product")
    public void i_am_redirected_to_another_page_that_presents_selected_product() {
        boolean status;
        status = driver.findElement(By.className("simpleCart_shelfItem")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I check the description section below the product images")
    public void i_check_the_description_section_below_the_product_images() {
        boolean status;
        status = driver.findElement(By.className("resp-tab-content-active")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I close the browser2")
    public void i_close_the_browser() {
        driver.quit();
    }

}
