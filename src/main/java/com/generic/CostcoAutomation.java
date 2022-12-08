package com.generic;
import java.sql.DriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import com.drivermanager.getBrowser;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {

	public static void productHandle() {
		//(1) Go to https://www.costco.com/
		
	WebDriver driver = getBrowser.getBrowsers("chrome");
	driver.manage().window().maximize();
	driver.navigate().to(Constants.CoscoURL);
	SeleniumWait.getImplicitWait(driver, 5);
	
	//(2) Get the page name => title >> getTitle()
	System.out.println("Home Page title/name = " + driver.getTitle());
	ScreenShot.getScreenShot(driver, "Cosco Home Welcome Page");
	
	//(3) Check/validate current URL is matched or not ==>getCurrentURL()
	
	System.out.println("Current page URL = " + driver.getCurrentUrl());
	//Expectation = Actual, Expectation
	SoftAssert sf = new SoftAssert();
	sf.assertEquals(driver.getCurrentUrl(),Constants.CoscoURL);
	
	//Go to sign in page
	SeleniumPageFactory pf = new SeleniumPageFactory(driver);
	SeleniumWait.getexplicitWait(driver, pf.getCostcoSignIn().get(0), 10);
	Highlighter.getColor(driver, pf.getCostcoSignIn().get(0), "red");
	pf.getCostcoSignIn().get(0).click();
	
	//5)	Get the page name
	System.out.println("Login Page title name = " + driver.getTitle());
	ScreenShot.getScreenShot(driver, "Cosco SignIn Page");
	
	//6) Go back to the home page >> navigate.back()
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	//This site has some problem. So we can use the same method twice or  
	//can use loop
	//or we can use same navigate method twice
	//driver.navigate().back();
	//driver.navigate().back();
	
	//another way if going back is not working
	while(true)
		if( pf.getCostcoSignIn().size()>0) {
			break;
		}else {
			driver.navigate().back();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
	//7) Read all Menu options and count Menu options below the login button
	
	System.out.println("Menu Count = " + pf.getCostcoMenuBTN().size());
	for(int i = 0; i<pf.getCostcoMenuBTN().size();i++) {
		Highlighter.getColor(driver, pf.getCostcoMenuBTN().get(i), "red");
		System.out.println(pf.getCostcoMenuBTN().get(i).getText());
	}
	
	//8) if the deal was there in the menu, then mouse over it and 
	//read all options
	//mouse over = Actions Class = moveElements()
	
	for(int i = 0; i<pf.getCostcoMenuBTN().size();i++) {
		if(pf.getCostcoMenuBTN().get(i).getText().contains("Deals")) {
		Highlighter.getColor(driver, pf.getCostcoMenuBTN().get(i), "red");
		Actions ac = new Actions(driver);
		ac.moveToElement(pf.getCostcoMenuBTN().get(i)).perform();
		
		System.out.println("Deal options count =" +pf.getDealOptions().size());
		//Read all deal options ==> Loop
		for(int j=0;j<pf.getDealOptions().size();j++) {
			Highlighter.getColor(driver, pf.getDealOptions().get(j), "Green");
			System.out.println( pf.getDealOptions().get(j).getText());
		}
	
	}
	
	}
	
	
	
	sf.assertAll();
	}
	
	
	public static void main(String[] args) {
		CostcoAutomation.productHandle();
	
		
		
	}
	
		
}
