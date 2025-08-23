package com.wiproJuly.JavaSdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		try {
			ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver= new ChromeDriver(co);
			
			driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=1448548843746502060&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062010&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
			
			Thread.sleep(2000);
			//maximize the window
			driver.manage().window().maximize();
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			
			WebElement aboutamz=driver.findElement(By.xpath("//a[normalize-space()='About Amazon']"));
			Actions act=new Actions(driver);
			Thread.sleep(2000);
			act.scrollToElement(aboutamz).perform();
			
			aboutamz.click();
			
			Thread.sleep(2000);
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			driver.quit();
			
			
		}
	}

}


