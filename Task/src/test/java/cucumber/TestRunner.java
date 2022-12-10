package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber"},
        features = {"src/test/java/cucumber/features.feature"}, glue = "cucumber")
public class TestRunner {
}
