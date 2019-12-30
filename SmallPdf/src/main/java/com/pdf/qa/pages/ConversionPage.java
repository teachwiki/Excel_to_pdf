package com.pdf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdf.qa.base.TestBase;

public class ConversionPage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//div[contains(text(),'Choose file')]")
	WebElement chooseFile;
	
	//initializing page obj
	public ConversionPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action:
	public void clickChoseFile(){
		chooseFile.click();
	}

}
