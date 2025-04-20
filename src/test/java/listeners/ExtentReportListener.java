package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.DriverFactory;
import utils.ScreenshotsUtil;

import java.io.IOException;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent-report.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);

    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("✅ Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String testName = result.getMethod().getMethodName();

        String screenshot = ScreenshotsUtil.takeScreenshot(driver,testName);

        test.addScreenCaptureFromPath(screenshot);
        test.fail("❌ Test failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("⚠️ Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Important: write everything to the report
    }
}
