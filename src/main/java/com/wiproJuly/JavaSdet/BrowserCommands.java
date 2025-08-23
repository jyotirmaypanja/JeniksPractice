package com.wiproJuly.JavaSdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {
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
		
		//get the source code of the html page
		String pgsrc=driver.getPageSource();
		System.out.println(pgsrc);
		
		//fetch the current url
		
		String url1=driver.getCurrentUrl();
		System.out.println(url1);
		
		//close the current window
		driver.close();
		
		
	}

}
