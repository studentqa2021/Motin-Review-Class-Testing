package com.cucumber.test;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.drivermanager.getBrowser;
import com.seleniumpagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	
	@Given("open any browser")
	public void open_any_browser() {
	    driver = getBrowser.getBrowsers("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 5);
	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "LogIn Page");
			//first signin
		 pf = new SeleniumPageFactory(driver);
		
	}

	@When("Click signin button")

	public void click_signin_button() {
		SeleniumWait.getexplicitWait(driver, pf.getSignInxpath().get(0), 0);
		Highlighter.getColor(driver, pf.getSignInxpath().get(0));
		pf.getSignInxpath().get(0).click();
		ScreenShot.getScreenShot(driver, "Home Page");
	}

	@When("put email")
	public void put_email() {
		Highlighter.getColor(driver, pf.getUserNamexpath());
		pf.getUserNamexpath().click();
		pf.getUserNamexpath().sendKeys("sarowerny@gmail.com");

	}

	@When("put password")
	public void put_password() {
		Highlighter.getColor(driver, pf.getPassWdxpath());
		pf.getPassWdxpath().click();
		pf.getPassWdxpath().sendKeys("Student123$");

	}

	@When("Click second signin button")
	public void click_second_signin_button() {
		Highlighter.getColor(driver, pf.getSecondsignINxpath());
		pf.getSecondsignINxpath().click();
		ScreenShot.getScreenShot(driver, "Validation");

	}

	@Then("Validate login was successful")
	public void validate_login_was_successful() {
		boolean status=pf.getValidation().get(0).isDisplayed();
		
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(status);
		sf.assertAll();

	}

}
