package com.wirecard.ntltaxi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wirecard.ntltaxi.initializer.DriverFunctions;
import com.wirecard.ntltaxi.initializer.Initializer;

public class HomePage extends  Initializer{

	public static void enterUsername(String Username)
	{
		//wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]")).sendKeys("test a");
		//make as replace usable
		
		getElementByXpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(Username);
		
		
	}
	
	public static void enterMobileNumber(String MobileNo)
	{
		getElementByXpath("HOMEPAGE_TYPE_MOBILENO_XPATH").sendKeys(MobileNo);
	}
	
	public static void enterPickupaddress(String pickupaddress)
	{
		getElementByXpath("HOMEPAGE_TYPE_PICKUPADDRESS_XPATH").sendKeys(pickupaddress);
	}

	public static void enterDropaddress(String dropaddress)
	{
		getElementByXpath("HOMEPAGE_TYPE_DROPADDRESS_XPATH").sendKeys(dropaddress);
		
	}
	public static void clickbooklater()
	{
		getElementByXpath("HOMEPAGE_TYPE_BOOKLATER_XPATH").click();
	}
	
	public static void selectbasic(String option)
	{
		WebElement element = getElementByXpath("HOMEPAGE_TYPE_BASIC_XPATH");
		DriverFunctions.selectDropDownByVisibleText(element, option);
		
	}
}
