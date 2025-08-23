package com.wiproJuly.JavaSdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
			ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver= new ChromeDriver(co);
			
			driver.get("https://the-internet.herokuapp.com/windows");
			
			Thread.sleep(2000);
			//maximize the window
			driver.manage().window().maximize();
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			
			WebElement clickhere=driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
			clickhere.click();
			
			Thread.sleep(2000);
			
			//fetch all window handles - there will be two (0) - default ,[1]new window
			//click on link to open new window
			Object[] windowHandles =driver.getWindowHandles().toArray();
			System.out.println(windowHandles);
			
			driver.switchTo().window((String)windowHandles[1]);
			
			//assert on title of new window 
			String title =driver.getTitle();
			System.out.println(title);
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window((String)windowHandles[1]);
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			driver.quit();
			
			
		}
	}

}
