package com.wiproJuly.Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



//Hierarchy order -- S>T>C>M-------TEST --------S>T>C>M
//S->SUITE, T->TEST , C->CLASSES ,M->METHODS
public class TestAnnotations {
	@BeforeTest
	public void beforetest() {

		System.out.println("checking products");

	}

 
	
	@AfterTest
	public void aftertest() {

		System.out.println("removing products");

	}

	
	@BeforeClass
	public void beforeclass() {

		System.out.println("Opening the api connections");

	}

 
	
	@AfterClass
	public void afterclass() {

		System.out.println("closing the api connections");

	}

	
	
	@BeforeSuite
	public void beforesuite() {

		System.out.println("Opening the db connections");

	}

 
	
	@AfterSuite
	public void aftersuite() {

		System.out.println("closing the db connections");

	}

	
	@BeforeMethod
	public void beforemethod() {

		System.out.println("Launch browser");

	}

 
	
	@AfterMethod
	public void aftemethod() {

		System.out.println("closing the browser");

	}

	
	@Test
	public void testcase1() {
 
		System.out.println("Testcase1 is executed");

	}
 
	@Test

	public void testcase2() {
 
		System.out.println("Testcase2 is executed");
 
	}
 
	@Test

	public void testcase3() {
 
		System.out.println("Testcase3 is executed");
 
	}	
 

}
