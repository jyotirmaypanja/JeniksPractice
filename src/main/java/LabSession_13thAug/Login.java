package LabSession_13thAug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static void main(String[] args) throws InterruptedException {
ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//name locator
		//enter text in username field
		Thread.sleep(2000);
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		
		username.sendKeys("standard_user");
		Thread.sleep(2000);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		
		Thread.sleep(2000);
		
		WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
