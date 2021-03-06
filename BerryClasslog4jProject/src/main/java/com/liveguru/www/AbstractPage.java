package com.liveguru.www;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static InputStream fis;
	protected static Logger logger = LogManager.getLogger("TestLogger");

	public AbstractPage (WebDriver driver){
		this.driver = driver;
				
		try {
			fis = new FileInputStream("C:\\JavaProject\\GitHub_Projects\\automation_selenium_code_repo\\BerryClasslog4jProject\\src\\main\\resources\\testDataRepo.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void OpenAndMaximizeBrowser(){
		driver.manage().window().maximize();
		logger.info("Browser opened and  maximize successfully");
		driver.navigate().to(config.getProperty("base_url"));
		logger.info("BaseUrl loaded successfully");
		
	}
	
	public void teardownbrowser(){
		driver.quit();
		logger.info("Browser closed successfully");
		driver = null;
		logger.info("Browser has no value");
	}
	
}
