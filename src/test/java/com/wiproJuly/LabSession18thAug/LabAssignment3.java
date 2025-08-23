package com.wiproJuly.LabSession18thAug;
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

@Listeners(TestNGListners.class)
public class LabAssignment3 {
	// Test Case 1: Positive Login Test
    @Test(dependsOnMethods = {"negativeUsernameTest()"},enabled=false)
    public void positiveLoginTest() throws InterruptedException {
    	
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(1000);
        
        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
       
        // Verify URL
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("logged-in-successfully")) {
        	System.out.println("logged-in-successfully");
        }else {
        	System.out.println("URL verification failed!");
        }
        
        

        
        // Verify success message
        WebElement message = driver.findElement(By.tagName("h1"));
        if(message.getText().contains("Logged In Successfully")){
        	System.out.println("Success Message Verified");
        }else {
        	System.out.println("Success message not found!");
        }
                     
        
        // Verify Log out button
        WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
        if(logoutBtn.isDisplayed()) {
        	System.out.println("Log out Button is displayed");
        }else {
        	System.out.println("Log out button is not displayed!");
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    // Test Case 2: Negative Username Test
    @Test(priority = 1)
    public void negativeUsernameTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        //verify hard assertion
        Thread.sleep(2000);

		String actualtitle = driver.getTitle();

		System.out.println(actualtitle);

		String expectedtitle = "Test Login ";

		// hard assertion  - the validation fails if the assertion is failing 

		Assert.assertEquals(actualtitle,expectedtitle);
        
        
        // Enter invalid username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUser");
        Thread.sleep(1000);
        
        // Enter valid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
        
        // Verify error message
        WebElement error = driver.findElement(By.id("error"));

        if (error.isDisplayed()) {
            String actualError = error.getText();
            if (actualError.equals("Your username is invalid!")) {
                System.out.println("Correct error message displayed.");
            } else {
                System.out.println("Unexpected error message");
            }
        } else {
            System.out.println("Error message not displayed!");
        }
        
        Thread.sleep(2000);
        driver.quit();
    }
    
    // Test Case 3: Negative Password Test
    @Test(priority = 2)
    public void negativePasswordTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        // Enter valid username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(1000);
        
        // Enter invalid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
        
        // Verify error message
        WebElement error = driver.findElement(By.id("error"));
        
        if (error.isDisplayed()) {
            String actualError = error.getText();
            if (actualError.equals("Your password is invalid!")) {
                System.out.println("Correct error message displayed");
            } else {
                System.out.println("Unexpected error message");
            }
        } else {
            System.out.println("Error message not displayed!");
        }
        
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
