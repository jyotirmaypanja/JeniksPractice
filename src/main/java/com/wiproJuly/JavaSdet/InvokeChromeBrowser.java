package com.wiproJuly.JavaSdet;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class InvokeChromeBrowser {
	public static void main(String[] args) throws InterruptedException {
		
		//ChromeOptions co=new ChromeOptions();
		
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//name locator
		//enter text in username field
		Thread.sleep(2000);
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("admin123");
		
		Thread.sleep(2000);
		
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		Thread.sleep(2000);
		
		
	}

}
