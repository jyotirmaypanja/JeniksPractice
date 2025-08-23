package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventeg {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
			ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			driver= new ChromeDriver(co);
			String url="https://www.instagram.com/";
			driver.get(url);
			
			Thread.sleep(2000);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//Actions class is used to  simulate mouse related activities
			
			Actions act=new Actions(driver);
			WebElement email=driver.findElement(By.xpath("//input[@name='username']"));
			act.moveToElement(email).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
			
			Thread.sleep(2000);
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			act.moveToElement(password).click().sendKeys("hi").release().build().perform();
			
			Thread.sleep(2000);
				
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			driver.quit();
			
		}
	}

}
