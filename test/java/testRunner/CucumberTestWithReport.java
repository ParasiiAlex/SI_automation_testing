package testRunner;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "stepDefinitions",
        plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports.html" }
)

public class CucumberTestWithReport {

}
