package com.wiproJuly.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgDataProvider {
	@DataProvider(name = "logindata", parallel = true)
	public Object[][] getData() {
 
		return new Object[][] {
 
				{ "admin", "admin123" }, { "adm", "admin123" }, { "admn", "admin123" }
 
		};
 
	}
 
	@Test(dataProvider = "logindata")
	public void loginTest(String username, String password) throws InterruptedException {
 
		
		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);

		// name locator
 
		// enter text in username field
 
		WebElement username1 = driver.findElement(By.name("username"));
 
	
		username1.sendKeys(username);
 
		// enter text in password field
		Thread.sleep(2000);
 
		WebElement password1 = driver.findElement(By.xpath("//input[@name = 'password']"));
 
		password1.sendKeys(password);
		Thread.sleep(2000);
 
		// click on login button
 
		WebElement loginbutton = driver.findElement(By.xpath("//button[@type = 'submit']"));
 
		loginbutton.click();

 }
}
