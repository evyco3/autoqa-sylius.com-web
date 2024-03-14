package co.il.evy.framework.reporter;

import co.il.evy.framework.logger.MyLogger;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter {

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        if (!suites.isEmpty()) {
            ISuite suite = suites.get(0);
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult suiteResult : suiteResults.values()) {
                ITestContext testContext = suiteResult.getTestContext();
                String testName = testContext.getName();
                int passedTests = testContext.getPassedTests().size();
                int failedTests = testContext.getFailedTests().size();

                MyLogger.logInfoWithThreadName("Test '" + testName + "' Results:");
                MyLogger.logInfoWithThreadName("Passed: " + passedTests);
                MyLogger.logInfoWithThreadName("Failed: " + failedTests);

                if (failedTests > 0) {
                    for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
                        String failedTestName = failedTest.getName();
                        MyLogger.logErrorWithThreadName("Test '" + failedTestName + "' failed.",null);
                    }
                }
            }
        } else {
            MyLogger.logInfoWithThreadName("No suites found.");
        }
    }
}