package com.qa.pdf.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pdf.qa.base.TestBase;



public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static boolean excelLogic(String filename) throws IOException, AWTException{
		//String filename= "C:\\Users\\Hp\\Documents\\apachePOI\\xlsx1sheet.xlsx";
		//String filename= "C:\\Users\\Hp\\Documents\\apachePOI\\csv.csv";//not supported in XSSFWorkbook/HSSFWorkbook
		//String filename= "C:\\Users\\Hp\\Documents\\apachePOI\\xlsm.xlsm";
		//String filename= "C:\\Users\\Hp\\Documents\\apachePOI\\xlsb.xlsb";//xlsb not supported in XSSFWorkbook/HSSFWorkbook
		//String filename= "C:\\Users\\Hp\\Documents\\apachePOI\\xls.xls";//needs HSSFWorkbook
		
		int a=0,b=0;
		if(filename.contains(".xlsx")||filename.contains(".xlsm")){
			FileInputStream fis = new FileInputStream(filename);
			XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
			//System.out.println(workbook1.getNumberOfSheets());
			int countSheets = workbook1.getNumberOfSheets();//count the number of sheets
			workbook1.close();
			a=countSheets;
			
		}
		
		else if(filename.contains(".xls")){
			POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(filename));
			HSSFWorkbook workbook2 = new HSSFWorkbook(fileSystem);
			//System.out.println(workbook2.getNumberOfSheets());
			int countSheets = workbook2.getNumberOfSheets();
			workbook2.close();
			b=countSheets;
			
		}
		
		else{
			System.out.println("wrong file type");
			return false;
		}
		
		// calling Robot class to upload excel
		if(a==1||b==1){
			Robot robot = new Robot();
			robot.setAutoDelay(2000);
	        StringSelection selection = new StringSelection(filename);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
	 
	        robot.setAutoDelay(1000);
	 
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	 
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_V);
	 
	        robot.setAutoDelay(1000);
	 
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        return true;
	        
		}
		else
			System.out.println("more than 1 sheet in workbook");
			return false;
		
		
		
		
	
	
        
	}
}
