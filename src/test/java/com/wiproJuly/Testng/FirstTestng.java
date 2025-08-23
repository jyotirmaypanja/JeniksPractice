package com.wiproJuly.Testng;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestng {

	@Test
	public void launchbrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://the-internet.herokuapp.com/windows");
		// maximize the window
		driver.manage().window().maximize();
		
	}
	
	
	// Default priority = 0 (if not mentioned).

		//If multiple test methods have the same priority, they run in alphabetical order.

		// Lower priority value = Higher execution order priority = 0 runs before priority = 1.

		@Test(priority=2)

		public void testalerts() throws InterruptedException {

			ChromeOptions chromeOptions = new ChromeOptions();
	 
			WebDriverManager.chromedriver().setup();
	 
			WebDriver driver = new ChromeDriver(chromeOptions);
	 
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");

			// maximize the window

			driver.manage().window().maximize();

			// click on simple alert 

			WebElement simplealert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));

			simplealert.click();

			Thread.sleep(2000);

			Alert alt = driver.switchTo().alert();

			// click on ok button

			alt.accept();

			Thread.sleep(2000);


			// click on confirmational  alert 

			WebElement confirmalert = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));

			confirmalert.click();

			Thread.sleep(2000);

			Alert alt1 = driver.switchTo().alert();

			// click on cancel  button

			alt1.dismiss();

			Thread.sleep(2000);

			// click on prompt   alert 

			WebElement pronmptalert = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));

			pronmptalert.click();

			Thread.sleep(2000);

			Alert alt2 = driver.switchTo().alert();

			// click on ok button

			String alerttext = alt2.getText();

			System.out.println(alerttext);

			alt2.sendKeys("Harsha");

			Thread.sleep(2000);

			alt2.accept();

			Thread.sleep(2000);

		}

		@Test(priority=1)

		public void testcheckbox() throws InterruptedException {

	 
			ChromeOptions chromeOptions = new ChromeOptions();
	 
			WebDriverManager.chromedriver().setup();
	 
			WebDriver driver = new ChromeDriver(chromeOptions);
	 
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


			WebElement checkbox = driver.findElement

					(By.xpath("//input[@id = 'checkBoxOption1']"));

			checkbox.click();

			Thread.sleep(2000);
	 
		}

		@Test(priority=0)

		public void testdragdrop() throws InterruptedException {


			System.setProperty("webdriver.edge.driver", "C:\\Users\\Harsha Patil\\Desktop\\Corporate Trainings\\IIHT\\Screen shots\\edgedriver_win64\\msedgedriver.exe");

			// Create EdgeDriver instance

			WebDriver driver = new EdgeDriver();
	 
			driver.get("https://the-internet.herokuapp.com/drag_and_drop");
	 
			// maximize the window
	 
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	 
			// Actions class is used to simiulate the mouse related activites
	 
			Actions act = new Actions(driver);
	 
			WebElement from = driver.findElement(By.id("column-a"));
	 
			WebElement to = driver.findElement(By.id("column-b"));
	 
			act.dragAndDrop(from, to).perform();
	 
			Thread.sleep(2000);
	 
		}

		@Test

		public void  radiobuttons() throws InterruptedException {

			ChromeOptions chromeOptions = new ChromeOptions();
	 
			WebDriverManager.chromedriver().setup();
	 
			WebDriver driver = new ChromeDriver(chromeOptions);
	 
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");


			WebElement Radio3 = driver.findElement(By.xpath("//input[@value = 'radio3']"));

			Radio3.click();

			Thread.sleep(2000);

		}

}
