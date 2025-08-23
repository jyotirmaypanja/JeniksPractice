package com.wiproJuly.JavaSdet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertEg {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		Thread.sleep(2000);
		//maximize the window
		driver.manage().window().maximize();
		//click on simple alert
		
		WebElement simplealert=driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
		simplealert.click();
		
		Thread.sleep(2000);
		
		Alert alt=driver.switchTo().alert();
		//click on ok button
		alt.accept();
		
		Thread.sleep(2000);
		
		//click on confirmatioanal alert
		
		WebElement confirmAlert =driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
		confirmAlert.click();
		
		Thread.sleep(2000);
		
		Alert alt1=driver.switchTo().alert();
		
		//click on cancel button
		alt1.dismiss();
		
		Thread.sleep(2000);
		
		//click  on prompt alert
		
		WebElement PromptAlert =driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
		PromptAlert.click();
		
		Thread.sleep(2000);
		Alert alt2=driver.switchTo().alert();
		
		//click on ok button
		String aleertText=alt2.getText();
		System.out.println(aleertText);
		alt2.sendKeys("Jyotirmay");
		Thread.sleep(2000);
		alt2.accept();
		Thread.sleep(2000);
		
		
		
		
		
		
	}

}
