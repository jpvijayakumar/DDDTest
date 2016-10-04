package com.wirecard.ntltaxi.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.ScreenshotListener;
import com.wirecard.ntltaxi.initializer.DriverFunctions;
import com.wirecard.ntltaxi.initializer.Initializer;
import com.wirecard.ntltaxi.inputReader.inputReader;
import com.wirecard.ntltaxi.pageobjects.HomePage;
import com.wirecard.ntltaxi.reportGeneration.ScreenShotGenerator;

public class HomePageTest extends Initializer {

	@BeforeClass

	public void Setup() throws IOException

	{

		Initialize();

	}

	@Test(dataProvider = "HomePageTest")

	public void validateHomePage(String testdata, String Username, String Mobileno, String Pickupaddress,
			String Dropaddress, String basic) throws IOException {

		DriverFunctions.loadurl();
		log = report.startTest(testdata);

		HomePage.enterUsername(Username);
		HomePage.enterMobileNumber(Mobileno);
		HomePage.enterPickupaddress(Pickupaddress);
		HomePage.enterDropaddress(Dropaddress);
		HomePage.selectbasic(basic);
		HomePage.clickbooklater();

	}

	@DataProvider(name = "HomePageTest")

	public static Object[][] getHomePageData() throws Exception {

		
		if(inputReader.RunModeVerification("HomePageTest")){
		//Object[][] data = new Object[3][6];
			Object[][] data = inputReader.selectSingleDataOrMulitiData("HomePageTest");
			

//		data[0][0] = "HomePageTest_dataset1";
//		data[0][1] = "Test A";
//		data[0][2] = "25365263562";
//		data[0][3] = "ADYAR";
//		data[0][4] = "ADYAR";
//		data[0][5] = "Sedan";
//
//		data[1][0] = "HomePageTest_dataset2";
//		data[1][1] = "Test B";
//		data[1][2] = "73647374673864";
//		data[1][3] = "ADYAR";
//		data[1][4] = "ADYAR";
//		data[1][5] = "Sedan";
//
//		data[2][0] = "HomePageTest_dataset3";
//		data[2][1] = "Test C";
//		data[2][2] = "12123434";
//		data[2][3] = "ADYAR";
//		data[2][4] = "ADYAR";
//		data[2][5] = "Sedan";
		return data;
		}
		return null;

	}

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException {

		ScreenShotGenerator.takeScreenShot(result);
		
		

	}

}
