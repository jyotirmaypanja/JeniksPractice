package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			driver= new ChromeDriver(co);
			String url="https://the-internet.herokuapp.com/drag_and_drop";
			driver.get(url);
			Thread.sleep(2000);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//Actions class is used to  simulate mouse related activities
			
			Actions act=new Actions(driver);
			
			WebElement from=driver.findElement(By.id("column-a"));
			WebElement to=driver.findElement(By.id("column-b"));
			
			act.dragAndDrop(from, to).perform();
			
			Thread.sleep(2000);
			
			
		}catch(Exception e) {
			
		}finally {
			driver.close();
			
		}
	}

}
