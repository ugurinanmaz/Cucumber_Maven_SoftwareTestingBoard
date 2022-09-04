package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =  {   "src/test/java/FeatureFiles/LoginTest.feature",
                        "src/test/java/FeatureFiles/_02_Country.feature"
                    },
        glue = {"StepDefinitions"},
        dryRun = true  // true oldugunda testi calistirma sadece featurelara ait steplerin varligini kontrol eder.
                        // false oldugunda ise testleri calistiriyor
)
public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}
