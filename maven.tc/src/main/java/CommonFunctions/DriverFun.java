package CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import TestCases.BaseTest;

public class DriverFun {

	private WebDriver driver = null;

	public DriverFun(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sspath = System.getProperty("user.dir") + "/Screenshots/SS" + currentDate() + ".png";
		try {
			FileHandler.copy(src, new File(sspath));
			System.out.println("ScreenShot taken!");

		} catch (IOException e) {
			System.out.println("Unable to SS!! " + e.getMessage());
			BaseTest.test.log(Status.FAIL, "in exception block  " + e.getMessage());

		}
		return sspath;
	}

	public static String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat(" " + "MM_dd_yyyy_HH_mm_ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		return dateFormat.format(date);

	}
}
