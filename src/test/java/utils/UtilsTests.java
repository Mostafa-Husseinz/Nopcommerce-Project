package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static login.LoginTests.actualResult;
import static login.LoginTests.expectedResult;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utils.MethodHandles.extent;
import static utils.MethodHandles.test;

public class UtilsTests {
    WebDriver driver;


    public UtilsTests(WebDriver driver) {
        this.driver = driver;
    }

    public void createTestCaseInReport(Method method) {
        test = extent.createTest(method.getName());
        test.info(MarkupHelper.createLabel("-------Steps To Reproduce-------", ExtentColor.INDIGO));
    }

    public static void endOfSteps() {
        test.info(MarkupHelper.createLabel("-------Ends Of Steps-------", ExtentColor.INDIGO));

    }

    public void takeScreenShots(Method method) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("report/" + method.getName() + ".png"));
    }

    public void createReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);

    }

    public void setStatus(Method method, ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Pass");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Fail");
        }
        test.addScreenCaptureFromPath(method.getName() + ".png");
        test.log(Status.INFO, "<a href=' " + method.getName() + ".avi'> Download Video</a>");
    }

    public void flushReport() {
        extent.flush();
    }

    public static void myAssertEquals(String expected, String actual) {
        endOfSteps();
        test.info(MarkupHelper.createLabel("-------Expected Result-------", ExtentColor.AMBER));
        test.info(expected);
        test.info(MarkupHelper.createLabel("-------Actual Result-------", ExtentColor.AMBER));
        test.info(actual);
        assertEquals((String) null, (String) expected, (String) actual);
    }

    public static void myAssertTrue(boolean condition) {
        endOfSteps();
        test.info(MarkupHelper.createLabel("-------Expected Result-------", ExtentColor.AMBER));
        test.info(expectedResult);
        test.info(MarkupHelper.createLabel("-------Actual Result-------", ExtentColor.AMBER));
        test.info(actualResult);


        assertTrue((String) null, condition);
    }

}



