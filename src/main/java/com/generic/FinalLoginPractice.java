package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.drivermanager.getBrowser;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalLoginPractice {

	public static void getFinalLogin() {
		
		WebDriver driver= getBrowser.getBrowsers("chrome");
		driver.manage().window().maximize();
		
		//open URL
		driver.get(Constants.URL);
		//HomePage -- ScreenShot
		ScreenShot.getScreenShot(driver, "Home Page");
		
		
		//creating object of Page Factory
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
				
		SeleniumWait.getImplicitWait(driver, 5);
		
		//signin
		Highlighter.getColor(driver, pf.getSignInxpath().get(0), "red");
		pf.getSignInxpath().get(0).click();
		//LogIn Page--Screenshot
		ScreenShot.getScreenShot(driver, "LogIn");
		//UserName
		Highlighter.getColor(driver, pf.getUserNamexpath(), "red");
		pf.getUserNamexpath().click();
		pf.getUserNamexpath().sendKeys(Constants.User);
		//Password
		Highlighter.getColor(driver,pf.getPassWdxpath(), "red");
		pf.getPassWdxpath().click();
		pf.getPassWdxpath().sendKeys(Constants.Passwd);
		
		//2ndSignin
		driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
		//Validateion -- Screenshot
		ScreenShot.getScreenShot(driver, "Validation");
		
		//Validation
		Boolean status = pf.getValidation().get(0).isDisplayed();
		
		//validate by java
		if(driver.findElement(By.xpath("(//*[@class='greet welcome'])[1]")).isDisplayed()) {
			System.out.println("Test Pass");
		} else{
			System.out.println("Test Failed");
		}
		
		//HardAssert
		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed());
		//SoftAssert
		SoftAssert as = new SoftAssert();
		as.assertTrue(status); //status = code for Welcome 
		as.assertAll();
		
		//driver.quit();
			
	}
	
		public static void main(String[] args) {
		FinalLoginPractice.getFinalLogin();
	}
	
	
	
	
}
