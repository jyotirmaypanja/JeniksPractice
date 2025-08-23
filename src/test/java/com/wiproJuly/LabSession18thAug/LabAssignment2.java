package com.wiproJuly.LabSession18thAug;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//End-to-End Booking Flow
//Practice: Automate a full flow like hotel/flight booking.

public class LabAssignment2 {
	
	WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://phptravels.net/");
    }
	
    @Test
	public void signup() throws InterruptedException {
		WebElement customerMenu = driver.findElement(By.xpath("//span[normalize-space()='Customer']"));
        customerMenu.click();
        Thread.sleep(2000);
        // Click Signup
        driver.findElement(By.xpath("//a[@href='https://phptravels.net/signup']")).click();
        Thread.sleep(2000);
        // Fill Signup Form
        driver.findElement(By.name("first_name")).sendKeys("Jyotirmay");
        driver.findElement(By.name("last_name")).sendKeys("Panja");
        driver.findElement(By.name("phone")).sendKeys("9000000000");
        WebElement countryDropdown = driver.findElement(By.cssSelector("input[aria-label='Search']"));
        countryDropdown.click();

        // Option 1: Direct click from dropdown list
        WebElement indiaOption = driver.findElement(By.xpath("//a[@id='bs-select-1-99']//span[@class='text']"));
        indiaOption.click();
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("jyotirmay@gamil.com" );
        driver.findElement(By.name("password")).sendKeys("Test@1234");
        driver.findElement(By.name("confirm_password")).sendKeys("Test@1234");

        // Submit
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();

        // Verify successful registration (page shows account or welcome text)
        Thread.sleep(3000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Account") || bodyText.contains("Welcome"),
                "Signup may have failed - verification text not found!");
        
        
        Thread.sleep(2000);
        driver.quit();
	}
	

}
