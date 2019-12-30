package com.pdf.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.pdf.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try{
				prop = new Properties();
			 	FileInputStream ip = new FileInputStream("C:/Users/Hp/eclipse-workspace/SmallPdf/src"
			 			+ "/main/java/com/pdf/qa/config/config.properties");
				prop.load(ip);
			}	catch(FileNotFoundException e){
				e.printStackTrace();
			}	catch (IOException e){
				e.printStackTrace();
			}
	
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C://Users//Hp//Documents//apachePOI//chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "C://Users//Hp//Downloads//geckodriver-v0.19.1-win32//geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C://Users//Hp//Downloads//IEDriverServer_Win32_3.150.1//IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	
}
