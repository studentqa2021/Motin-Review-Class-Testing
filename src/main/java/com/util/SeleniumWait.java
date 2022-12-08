package com.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {
public static void getImplicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	
public static void getImplicitWait(WebDriver driver, int timeInSeconds) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		}
	
	public static void getexplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		public static void getexplicitWait(WebDriver driver, WebElement element, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}}
	
	
	

