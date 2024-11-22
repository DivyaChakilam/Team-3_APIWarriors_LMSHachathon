package api.StepDefinitions;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Hooks {
	private static PrintStream printStream;

    static {
        try {
            printStream = new PrintStream(new FileOutputStream("Team3RestAssuredLog.txt", true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize logging file.");
        }
    }

    @Before
    public void beforeScenario() {
        RestAssured.filters(new RequestLoggingFilter(printStream), new ResponseLoggingFilter(printStream));
    }

    @After
    public void afterScenario() {
        printStream.println("\n--- End of Scenario ---\n");
    }

    public static void closeStream() {
        if (printStream != null) {
            printStream.close();
        }
    }
}
