package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.getBrowser;
import com.report.ExtentReportAutomation;
import com.util.Constants;
import com.util.SeleniumWait;

public class GoogleWithTestNG extends ExtentReportAutomation  {
@BeforeTest
public void setUp() {
	WebDriver driver = getBrowser.getBrowsers("chrome");
	driver.manage().window().maximize();
	SeleniumWait.getImplicitWait(driver, 5);
	//URL open
	driver.navigate().to("https://www.google.com/");
}
@Test
public void loginTest() {
	
}
@AfterTest
public void tearDown() {
	
}
}
