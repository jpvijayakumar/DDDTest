package com.wirecard.ntltaxi.reportGeneration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.wirecard.ntltaxi.initializer.Initializer;

public class ReportOptimizer extends Initializer {

	@Test
	
	
	public static void archivefiles() throws IOException
	{
		if(isarchive)
		{
			
		
		SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH-mm-SS-mmm");
		//windows dont accept colon 
	String data=	sf.format(new Date());
		
	
	
	
		System.out.println(data);
		File src = new File("C:\\Users\\KDheepak\\workspace\\DDDTest\\screenshot");
		File dest = new File("C:\\Users\\KDheepak\\workspace\\DDDTest\\archivefolder\\old"+data);
		
		
		FileUtils.copyDirectory(src, dest);
		FileUtils.cleanDirectory(src);
		
		
		
		isarchive=false;
		}
		
		
	}
	
	
}
