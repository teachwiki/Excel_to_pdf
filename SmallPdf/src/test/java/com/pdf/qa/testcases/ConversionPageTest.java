package com.pdf.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pdf.qa.base.TestBase;
import com.pdf.qa.pages.ConversionPage;
import com.qa.pdf.util.TestUtil;

public class ConversionPageTest extends TestBase {
	
	ConversionPage conversionpage;
	public ConversionPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		conversionpage = new ConversionPage();
	}
	
	@Test(priority=1)
	public void uploadXlsxWithSingleSheetTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath1"));
		Assert.assertTrue(flag);
	}
	
	/*@Test(priority=2)
	public void uploadXlsxWithTwoSheetsTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath2"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void uploadWordFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath3"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void uploadXlsxWithMultipleSheetsTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath4"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=5)
	public void uploadCsvFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath5"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=6)
	public void uploadXlsmFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath6"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=7)
	public void uploadXlsbFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath7"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=8)
	public void uploadXlsFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath8"));
		Assert.assertTrue(flag);
	}
	
	@Test(priority=9)
	public void uploadRenamedTxtFileTest() throws IOException, AWTException{
		conversionpage.clickChoseFile();
		Boolean flag = TestUtil.excelLogic(prop.getProperty("filepath9"));
		Assert.assertTrue(flag);
	}
	*/
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
