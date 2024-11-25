
package api.TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-Reports.html" , "json:target/cucumber.json",
				"junit:target/Cucumber.xml",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // JSON Report
				},
		monochrome=false,  //console output color
		features = {"src/test/resources/features" }, //location of feature files
		glue= {"api.StepDefinitions"}
		
		)
public class RunnerFile extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }

} 
