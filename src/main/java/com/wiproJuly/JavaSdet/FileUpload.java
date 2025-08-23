package com.wiproJuly.JavaSdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		WebElement fileupload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		fileupload.sendKeys("\"C:\\Users\\Dell\\Downloads\\WhatsApp Image 2025-05-22 at 23.07.10.jpeg\"");
		
		WebElement submit=driver.findElement(By.xpath("//input[@id='file-submit']"));
		submit.click();
		
		WebElement validationmsg=driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));
		
		 // Check upload confirmation message
        String message = driver.findElement(By.tagName("h3")).getText();
        
        if (message.contains("File Uploaded!")) {
            System.out.println("The file is uploaded successfully");
        } else {
            System.out.println("The file upload failed");
        }

        // Close browser
        driver.quit();
		
		
	}

}
