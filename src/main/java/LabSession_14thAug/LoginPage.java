package LabSession_14thAug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		//name locator
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Jyotirmay Panja");
		Thread.sleep(2000);
		
		//email locator
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("prabhaspanja54321@gmail.com");
		
		Thread.sleep(2000);
		
		//gender
		WebElement radioButton=driver.findElement(By.xpath("//input[@id='gender']"));
		 radioButton.click();
		Thread.sleep(2000);
	/*	
		WebElement radioButton1=driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//input[1]"));
		 radioButton1.click();
		Thread.sleep(2000);
		
		WebElement radioButton2=driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[3]//input[1]"));
		 radioButton2.click();
		Thread.sleep(2000);
	*/
		//mobile 
		
		WebElement mobile=driver.findElement(By.xpath("//input[@id='mobile']"));
		mobile.sendKeys("8986856002");
		
		Thread.sleep(2000);
		
	//dob
		
		Thread.sleep(2000);
		WebElement dob = driver.findElement(By.name("dob"));
		dob.sendKeys("21042003");
		
	//subjects
		WebElement subjects=driver.findElement(By.xpath("//input[@id='subjects']"));
		subjects.sendKeys("selenium Training");
		
		Thread.sleep(2000);
		
		 // Hobbies (Sports, Reading, Music)
        driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//label[text()='Reading']/preceding-sibling::input")).click();
        Thread.sleep(500);

        // Upload Picture
        driver.findElement(By.id("picture")).sendKeys("\"C:\\Users\\Dell\\Downloads\\file1.jpg\"");
        Thread.sleep(1000);

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Kolkata, West Bengal, India");
        Thread.sleep(1000);

        // State and City
        WebElement stateDropdown = driver.findElement(By.id("state"));
        stateDropdown.click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        
        Thread.sleep(1000);

        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
        Thread.sleep(1000);

        // Submit form (Login)
        driver.findElement(By.id("login")).click();

        Thread.sleep(3000);
        driver.quit();
		
		
		
	}

}
