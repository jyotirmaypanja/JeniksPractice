package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
	public static void main(String[] args) throws InterruptedException {
ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//name locator
		//enter text in username field
		Thread.sleep(2000);
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		checkBox.click();
		Thread.sleep(2000);
	}

}
