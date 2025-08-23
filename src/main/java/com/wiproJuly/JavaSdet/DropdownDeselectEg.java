package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDeselectEg {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(ChromeOptions);
		driver.get("https://grotechminds.com/multiple-select/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		

		WebElement dropdown=driver.findElement(By.xpath("//select[@id='automobiles']"));
		Select des = new Select(dropdown);
		
		Thread.sleep(2000);
		
		des.selectByContainsVisibleText("Motorcycle");
		Thread.sleep(2000);
		
		des.selectByValue("sedan");
		Thread.sleep(2000);
		
		des.selectByIndex(3);
		Thread.sleep(2000);
		
		des.selectByContainsVisibleText("SUV");
		Thread.sleep(2000);
		des.deSelectByContainsVisibleText("Motorcycle");
		Thread.sleep(2000);
	
		des.deselectByValue("sedan");
		Thread.sleep(2000);
	
		des.deselectByIndex(3);
		Thread.sleep(2000);
		
		des.deselectAll();
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
