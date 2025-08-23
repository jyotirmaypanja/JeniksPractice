package com.wiproJuly.Testng;

import org.testng.annotations.Test;

public class TestNgGroups {
	@Test (groups = {"Sanity" , "Regression"})
	public void testcase1() {
		System.out.println("Testcase1 is executed");

	}
	@Test (groups = {"Regression"})
	public void testcase2() {
		System.out.println("Testcase2 is executed");

	}
	@Test (groups = {"Sanity"})
	public void testcase3() {
		System.out.println("Testcase3 is executed");

	}
	@Test (groups = {"Regression"})
	public void testcase4() {
		System.out.println("Testcase4 is executed");

	}

}
