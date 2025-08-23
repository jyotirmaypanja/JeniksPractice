package com.wiproJuly.Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wiproJuly.LabSession18thAug.TestNGListners;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestNGListners.class)	
public class TestNG_ListnersTestcases {

	@Test
	public void testlogin() throws InterruptedException {

		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// name locator 
		// enter text in username field 
		Thread.sleep(2000);

			WebElement username = driver.findElement(By.name("username"));
		// explicit wait - applicable for single web element - selenium 4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(d -> username.isDisplayed());

		username.sendKeys("Admin");
		Thread.sleep(2000);
		// enter text in password field
		WebElement password = driver.findElement
				(By.xpath("//input[@name = 'password']"));
		// fluent wait 
		 Wait<WebDriver> wait1 =
			        new FluentWait<>(driver)
			            .withTimeout(Duration.ofSeconds(2))
			            .pollingEvery(Duration.ofMillis(300))
			            .ignoring(ElementNotInteractableException.class);
 
			    wait1.until(
			        d -> {
			        	password.sendKeys("Displayed");
			          return true;
			        });
		password.sendKeys("admin123");
		// click on login button
		Thread.sleep(2000);
		WebElement loginbutton = driver.findElement
				(By.xpath("//button[@type = 'submit']"));

		loginbutton.click();
		Thread.sleep(2000);

	}
 
}
