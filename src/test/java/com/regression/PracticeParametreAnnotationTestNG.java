package com.regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class PracticeParametreAnnotationTestNG {

	@Test
	@Parameters({"user","password"})
	public void test(String user,String password) {
		System.out.println(user);
		System.out.println(password);
	}
	
	
	
}
