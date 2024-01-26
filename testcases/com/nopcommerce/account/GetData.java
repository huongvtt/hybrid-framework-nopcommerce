package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class GetData extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir"); 
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browerDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() { 
		openPageUrl(driver, "https://dstest.info/DiaDict/Dictionary/1xRTT-RCID.html");
		String source = getPageSourceCode(driver);
		System.out.print(source);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
