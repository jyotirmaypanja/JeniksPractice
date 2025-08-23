package com.wiproJuly.LabSession18thAug;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Practice: Enter data, select dropdowns, checkboxes, radio buttons, and submit the form.

@Listeners(TestNGListners.class)
public class LabAssignment1 {
	@Test(groups = { "Sanity", "Regression" })
    public void lab1() throws InterruptedException {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("Jyotirmay");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("Panja");
		WebElement gender = driver.findElement(By.xpath("//input[@id='sex-0']"));
		gender.click();
		WebElement experience = driver.findElement(By.xpath("//input[@id='exp-0']"));
		experience.click();
		
		
		 Thread.sleep(2000);

			String actualtitle = driver.getTitle();

			System.out.println(actualtitle);

			String expectedtitle = "Techlistic - Atom ";

			// hard assertion  - the validation fails if the assertion is failing 

			Assert.assertEquals(actualtitle,expectedtitle);
			
			
		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("18-08-2025");
		WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
		profession.click();
		WebElement tools = driver.findElement(By.xpath("//input[@id='tool-2']"));
		tools.click();
		WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
		continents.click();
		WebElement commands = driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']"));
		commands.click();
		Thread.sleep(2000);
		WebElement upload = driver.findElement(By.xpath("//input[@id='photo']"));
		upload.sendKeys("C:\\Users\\princ\\Downloads\\New folder\\test-file.txt");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
		Thread.sleep(2000);
		
		driver.quit();
		
        
        
	}
	
	@BeforeTest
	public void beforetest() {

		System.out.println("checking products");

	}

 
	
	@AfterTest
	public void aftertest() {
		

		System.out.println("removing products");

	}

	
	@BeforeClass
	public void beforeclass() {

		System.out.println("Opening the api connections");

	}

 
	
	@AfterClass
	public void afterclass() {

		System.out.println("closing the api connections");

	}

	
	
	@BeforeSuite
	public void beforesuite() {

		System.out.println("Opening the db connections");

	}

 
	
	@AfterSuite
	public void aftersuite() {

		System.out.println("closing the db connections");

	}

	
	@BeforeMethod
	public void beforemethod() {

		System.out.println("Launch browser");

	}

 
	
	@AfterMethod
	public void aftemethod() {

		System.out.println("closing the browser");

	}

	
	@Test
	public void testcase1() {
 
		System.out.println("Testcase1 is executed");

	}
 
	@Test

	public void testcase2() {
 
		System.out.println("Testcase2 is executed");
 
	}
 
	@Test

	public void testcase3() {
 
		System.out.println("Testcase3 is executed");
 
	}	
	
	

}
