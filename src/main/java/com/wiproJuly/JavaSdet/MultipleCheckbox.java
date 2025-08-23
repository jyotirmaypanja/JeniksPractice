package com.wiproJuly.JavaSdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleCheckbox {
	public static void main(String[] args) throws InterruptedException {
ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//name locator
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@type='chechbox']"));
		int size=checkboxes.size();
		
		//for loop to iterate through checkbox
		
		for(int i=0;i<size;i++) {
			Thread.sleep(1000);
			checkboxes.get(i).click();
			Thread.sleep(2000);
		}
		
		
		
		
	}

}
