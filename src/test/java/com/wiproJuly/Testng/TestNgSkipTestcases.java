package com.wiproJuly.Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgSkipTestcases {
	@Test
	public void login() throws InterruptedException {
		 
		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
		// name locator
 
		// enter text in username field
 
		Thread.sleep(2000);
 
		WebElement username = driver.findElement(By.name("username"));
 
		username.sendKeys("Admin");
 
		Thread.sleep(2000);
 
		// enter text in password field
 
		WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
 
		password.sendKeys("admin123");
 
		// click on login button
 
		Thread.sleep(2000);
 
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type = 'submit']"));
 
		loginbutton.click();
 
		Thread.sleep(2000);
	}
 
	@Test(enabled=false)//skipping testcases
	public void testcheckbox() throws InterruptedException {
 
		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
		WebElement checkbox = driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']"));
 
		checkbox.click();
 
		Thread.sleep(2000);
 
	}


}
