package com.wiproJuly.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Automating Browser Navigation (Back, Forward, Refresh, Navigate To)
public class BrowserNavigation {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(co);
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		
		driver.get(url);
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//get the page title
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		
		//get the source code of the html page
		String pgsrc=driver.getPageSource();
		System.out.println(pgsrc);
		Thread.sleep(2000);
		
		//fetch the current url
		
		String url1=driver.getCurrentUrl();
		System.out.println(url1);
		Thread.sleep(2000);
		
		//naviagte to another url
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		//refresh url 
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		
		//close the current window
		driver.close();
		
	}

}
