package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Caminho das features
        glue = "steps", // Pacote com os steps
        plugin = {
                "json:target/report.json",
                "junit:target/reportJ.xml",
                "pretty",
                "html:target/cucumber-report.html", // Gera o HTML na pasta target
        }
)

public class CucumberRun {

}
