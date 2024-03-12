package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

//report generating

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"org.example.stepDefs"},
        plugin = {"pretty",
                "html:target/reports/reports.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        tags = "@smoke"

)
public class runners extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void setUp() {
        // Set up logic to initialize WebDriver instances for different browsers
    }

    @AfterSuite
    public void tearDown() {
        // Clean up resources after test execution
    }

}




