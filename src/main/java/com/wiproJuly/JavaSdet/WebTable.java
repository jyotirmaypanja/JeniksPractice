package com.wiproJuly.JavaSdet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		try {
			ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver= new ChromeDriver(co);
			
			driver.get("https://the-internet.herokuapp.com/tables");
			
			Thread.sleep(2000);
			//maximize the window
			driver.manage().window().maximize();
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			
			
			//find he row present 
			List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
					 int rowcount = rows.size();
					 System.out.println(rowcount);
					 
		  
			//find the column present
					 List<WebElement> cols=driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th"));
					 int clcount = cols.size();
					 System.out.println(clcount);	
			
					 
			//text of a cell
			WebElement cellText=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));	
			String actualText=cellText.getText();
			String expectedText="John";
			if(actualText.equalsIgnoreCase(expectedText)) {
				System.out.println("The text matches");
			}
			else
				System.out.println("The text not mathches");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			driver.close();
			
			
		}
	}


}
