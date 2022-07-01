package Runner;

import StepDefs.Base;
import com.aventstack.extentreports.gherkin.model.Background;
import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

@CucumberOptions(
        features = "src/test/Features"
        , glue = {"StepDefs"}
        , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Runner extends AbstractTestNGCucumberTests {
    Base base = new Base();

    @BeforeTest
    public void startAppium() {
        base.startAppiumServer();
    }

    @AfterTest
    public void stopAppium() {
        base.stopAppiumServer();
    }
}

