package com.wirecard.ntltaxi.initializer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initializer {

	public static void loadurl()
	{
		
		wd.get(envpro.getProperty("URL"));
	}
	
	public static void selectDropDownByVisibleText(WebElement element, String option)
	{
		Select s  = new Select(element);
	s.selectByVisibleText(option);
		
		
		
	
		
		
	}

}
