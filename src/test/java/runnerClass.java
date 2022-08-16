import cucumber.api.CucumberOptions;

        import cucumber.api.junit.Cucumber;



        import io.cucumber.testng.AbstractTestNGCucumberTests;

        import org.junit.runner.RunWith;





@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources"},

        tags ={"@SearchItem"},

        plugin = {

                "pretty", "html:target/cucumber-report/runwebat",

                "json:target/cucumber-report/runwebat/cucumber.json",

                "rerun:target/cucumber-report/runwebat/rerun.txt"},

        glue = "src/test/java/stepDefinition"

)



public class runnerClass extends AbstractTestNGCucumberTests {

}


