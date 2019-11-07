package serenityRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Zuzel
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/add_a_new_pet.feature", "src/test/resources/features/search_pet.feature" },
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        glue = "definitions"
)

public class TestRunner {

}
