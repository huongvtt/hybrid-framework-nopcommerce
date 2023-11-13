package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Static {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir"); 
	private BasePage basePage = BasePage.getBasePage();
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browerDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() {
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
