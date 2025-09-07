package com.wiproJuly.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBasic {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * get page url
		 * get page source code
		 * get page title 
		 * get page Handle 
		 */
		
		ChromeOptions co=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(co);
		String url="https://www.google.com/";
		driver.manage().window().maximize();
		
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		
		//get title 
		String s1=driver.getTitle();
		System.out.println(s1);
		Thread.sleep(2000);
		
	/*	//get source code
		System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		
		//get page Handle 
		System.out.println(driver.getWindowHandle());
		
		*/
		
		
		
	}
}
