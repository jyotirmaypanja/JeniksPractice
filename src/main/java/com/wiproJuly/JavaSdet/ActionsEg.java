package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEg {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
			ChromeOptions co=new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			
			driver= new ChromeDriver(co);
			String url="https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=8701379455575761687&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062010&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1";
			driver.get(url);
			
			Thread.sleep(2000);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//Actions class is used to  simulate mouse related activities
			
			Actions act=new Actions(driver);
			
			WebElement sell=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
			
			act.doubleClick(sell).perform();
			
			Thread.sleep(5000);
			driver.navigate().back();
			
			Thread.sleep(10000);
			
			//context click or right click
			WebElement mobiles=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
			act.contextClick().perform();
			
			
			
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		finally {
			driver.quit();
			
		}
	}
}
