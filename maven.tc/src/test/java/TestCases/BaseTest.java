package TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CommonFunctions.ConfigManager;
import CommonFunctions.Driver;
import CommonFunctions.DriverFun;
import PageFunctions.OtherFunctions;
import PageFunctions.SanityFunctions;


public class BaseTest {

	public static Driver d;
	public ExtentReports report;
	public ExtentTest classtest;
	public static ExtentTest test;

	protected SanityFunctions landingpage;
	protected OtherFunctions otherfunction;

	@BeforeSuite
	public void beforesuite() {
		Reporter.log("in the before suite", true);
		ExtentSparkReporter extent = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports+SS/TGH" + DriverFun.currentDate() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("settings done", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("CONFIG LOAD PROPERTIIES", true);

		try {
			ConfigManager.loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browser = ConfigManager.getProp().getProperty("browser");
		d = new Driver();
		d.startDriver(browser);
		landingpage = new SanityFunctions(d.getDriver());
		otherfunction = new OtherFunctions(d.getDriver());
		classtest = report.createTest(getClass().getName());
		classtest.log(Status.INFO, "inside the before test method");
	}

	@BeforeMethod
	public void beforMethod(Method method) {
		test = classtest.createNode(method.getName());
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		String pa = DriverFun.captureScreenshot(d.getDriver());
		if (result.getStatus() == ITestResult.SUCCESS) {
			classtest.info("Info");
			/*test.log(Status.PASS, result.getMethod().getMethodName() + "has passed");
			classtest.info(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(pa).build());*/
			
		} 
		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getMethod().getMethodName() + "has failed");
			classtest.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(pa).build());

		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getMethod().getMethodName() + "has skipped ");
			classtest.skip(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(pa).build());
			classtest.skip("Skipped!!", MediaEntityBuilder.createScreenCaptureFromPath(pa).build());
		}
		report.flush();
		Reporter.log("Report generated with screenshot", true);
	}

	@AfterTest
	public static void afterTest() {
		d.getDriver().quit();

	}

}
