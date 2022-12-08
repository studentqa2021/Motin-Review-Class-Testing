package com.seleniumpagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	WebDriver driver;
	public SeleniumPageFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
			}

	@FindBy(xpath="//*[@class='authorization-link']")
	private List<WebElement> signInxpath;
	
	@FindBy(xpath="//*[@id='email']")
	private WebElement userNamexpath;
	
	@FindBy(xpath="//*[@type='password']")
	private WebElement passWdxpath;
	
	@FindBy(xpath="//*[@class='action login primary']")
	private WebElement secondsignINxpath;
	
	@FindBy(xpath="//*[@class='greet welcome']")
	private List<WebElement> validation;
	
	@FindBy(xpath="//*[text()= 'Sign In / Register']")
	private List<WebElement> costcoSignIn;
	
	@FindBy(xpath="//*[@id='navigation-widget']//a")
	private List<WebElement> costcoMenuBTN;
	
	@FindBy(xpath ="//*[@class='sub-item']")
	private List<WebElement> dealOptions;

	public List<WebElement> getDealOptions() {
		return dealOptions;
	}

	
	public List<WebElement> getCostcoMenuBTN() {
		return costcoMenuBTN;
	}

	public List<WebElement> getCostcoSignIn() {
		return costcoSignIn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getSignInxpath() {
		return signInxpath;
	}

	public WebElement getUserNamexpath() {
		return userNamexpath;
	}

	public WebElement getPassWdxpath() {
		return passWdxpath;
	}

	public WebElement getSecondsignINxpath() {
		return secondsignINxpath;
	}

	public List<WebElement> getValidation() {
		return validation;
	}

	
	
	
	
	
}
