package PracticeDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocator {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//tagname +id 
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Tshirt");
		
		//tag name +class name
	}

}
