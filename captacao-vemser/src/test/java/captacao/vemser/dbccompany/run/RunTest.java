package captacao.vemser.dbccompany.run;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Cenario
        features = "src/main/resources/feature" ,

        // cenario de teste
        tags = {"@wip"},

        // Steps
        glue = "saucedemo/steps"

)

public class RunTest {

}
