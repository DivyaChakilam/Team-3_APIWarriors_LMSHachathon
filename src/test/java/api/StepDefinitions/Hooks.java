package api.StepDefinitions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Hooks {
	 // Log stream to capture log output
    private static ByteArrayOutputStream logStream = new ByteArrayOutputStream();
    private static PrintStream printStream = new PrintStream(logStream);

    @Before
    public void beforeScenario() {
        // Initialize RestAssured logging filters before each scenario
        RestAssured.filters(new RequestLoggingFilter(printStream), new ResponseLoggingFilter(printStream));
    }

    @After
    public void afterScenario() {
        // After each scenario, print the logs to the console
        System.out.println("Request and Response Logs:\n" + logStream.toString());
        
        // Reset the logStream to clear logs for the next scenario
        logStream.reset();
    }
}
