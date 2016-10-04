package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {

	public static WebDriver wd;

	public static ExtentReports report;

	public static ExtentTest log;

	// inbuild log file or separate log file

	@Test(priority = 1)

	public void googleTest() {

		wd = new FirefoxDriver();
		report = new ExtentReports("C:\\Users\\KDheepak\\workspace\\DDDTest\\reports\\Sample.html");
		log = report.startTest("Googletest");
		wd.get("https://www.google.co.in/");

	}

	@Test(priority = 2)

	public void yahooTest() {

		log = report.startTest("yahootest"); //give for log4j
		wd.get("https://login.yahoo.com/");

	}

	@Test(priority = 3)

	public void bingTest() {

		log = report.startTest("bingtest"); // it is get logged sa extent rep
		wd.get("https://www.bing.com/");

	}

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException { // screen shot

		if (result.isSuccess()) {

			String path = getscreenshot(result.getName());

			log.addScreenCapture(path);

			log.log(LogStatus.PASS, "TestCase Pass", path);

		} else {

			String path = getscreenshot(result.getName());

			log.addScreenCapture(path);

			log.log(LogStatus.FAIL, "TestCase Pass", path);

		}

		report.endTest(log);
		report.flush(); 
	}

	public static String getscreenshot(String name) throws IOException {
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\KDheepak\\workspace\\DDDTest\\screenshot\\" + name + ".jpg");

		FileUtils.copyFile(src, des);
		return des.toString(); // screnn shot and also path

	}

}
