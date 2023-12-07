package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/Customer.feature",
        glue = "stepDefinations", // package name
        dryRun = false, //  dryRun = true check every step has step definition or not
        monochrome = true, // remove unnecessary character in console
        plugin = {"pretty", "html:target/test-output.html"}
               )

public class testRun {

}
