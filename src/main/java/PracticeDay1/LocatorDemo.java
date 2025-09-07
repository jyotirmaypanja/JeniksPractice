package PracticeDay1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocatorDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//name locator 
		//driver.findElement(By.name("username")).sendKeys("Jyotirmay");
		
		//id locator
	/*	boolean logoDisplayedStatus=driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logoDisplayedStatus);*/
		
		
		//linktext and partiallinktext
		//driver.findElement(By.linkText("Contact")).click();
		//Thread.sleep(2000);
		
		//partial link text
		
		//driver.findElement(By.partialLinkText("Ab")).click();
		
		//class
		
		// List<WebElement>link =driver.findElements(By.className("thumbnail"));
		// System.out.println(link.size());
		
		 
		 //tag
		 List<WebElement>link =driver.findElements(By.tagName("a"));
		 System.out.println(link.size());
		 List<WebElement>link1 =driver.findElements(By.tagName("img"));
		 System.out.println(link1.size());
		 
		 
		 
		}

}
