package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.getBrowser;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
public void getLogin() {
	
	//browser open
	WebDriver driver = getBrowser.getBrowsers("chrome");
	driver.manage().window().maximize();
	SeleniumWait.getImplicitWait(driver, 5);
	
	//URL open
	driver.navigate().to(Constants.URL);
	ScreenShot.getScreenShot(driver, "LogIn Page");
	
	//first signin
	SeleniumPageFactory pf = new SeleniumPageFactory(driver);
	SeleniumWait.getexplicitWait(driver, pf.getSignInxpath().get(0), 0);
	
	Highlighter.getColor(driver, pf.getSignInxpath().get(0));
	pf.getSignInxpath().get(0).click();
	ScreenShot.getScreenShot(driver, "Home Page");
	
	
	//Username
	Highlighter.getColor(driver, pf.getUserNamexpath());
	pf.getUserNamexpath().click();
	pf.getUserNamexpath().sendKeys("sarowerny@gmail.com");
	
	//password
	Highlighter.getColor(driver, pf.getPassWdxpath());
	pf.getPassWdxpath().click();
	pf.getPassWdxpath().sendKeys("Student123$");
	
	//secondsignin
	Highlighter.getColor(driver, pf.getSecondsignINxpath());
	pf.getSecondsignINxpath().click();
	ScreenShot.getScreenShot(driver, "Validation");
	//validation
	boolean status=pf.getValidation().get(0).isDisplayed();
	
	SoftAssert sf = new SoftAssert();
	sf.assertTrue(status);
	sf.assertAll();
	
	
	
	
}
	
	
	
	
	
	
	
}
