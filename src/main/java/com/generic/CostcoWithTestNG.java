package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.getBrowser;
import com.util.SeleniumWait;

public class CostcoWithTestNG {
	@BeforeTest
	public void setUp() {
		WebDriver driver = getBrowser.getBrowsers("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 5);
		//URL open
		driver.navigate().to("https://www.costco.com/");
	}
	@Test
	public void loginTest() {
		
	}
	@AfterTest
	public void tearDown() {
		
	}
}
