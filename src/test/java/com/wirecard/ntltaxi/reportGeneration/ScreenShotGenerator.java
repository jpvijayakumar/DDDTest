package com.wirecard.ntltaxi.reportGeneration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.wirecard.ntltaxi.initializer.Initializer;

public class ScreenShotGenerator extends Initializer {

	public  static void takeScreenShot(ITestResult result) throws IOException { // screen shot

		Object[] data =result.getParameters(); 
		
		
		if (result.isSuccess()) 
		
		{

			String path = getscreenshot(data[0].toString());

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
