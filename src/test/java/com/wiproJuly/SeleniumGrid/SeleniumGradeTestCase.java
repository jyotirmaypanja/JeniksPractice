package com.wiproJuly.SeleniumGrid;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class SeleniumGradeTestCase extends HelperClass{
	
	@Test
	public void login() throws InterruptedException {


		WebElement Username = getDriver().findElement(By.xpath("//input[@placeholder='Username']"));

		Username.sendKeys("Admin");

		Thread.sleep(5000);

		// name locator 

		WebElement Password  = getDriver().findElement(By.xpath("//input[@placeholder='Password']"));

		Password.sendKeys("admin123");

		Thread.sleep(5000);

		WebElement LoginButton = getDriver().findElement(By.xpath("//button[@type='submit']"));

		LoginButton.click();

		Thread.sleep(2000);

	}
 

}
