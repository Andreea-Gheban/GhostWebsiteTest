import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/html_report/latest_run.html", "rerun:target/failed_scenarios.txt"},
        features = "C:\\Users\\Admin\\IdeaProjects\\ghost\\src\\test\\features",
        glue = {"steps"},
        tags = "@regression")

public class TestRunner{
}
