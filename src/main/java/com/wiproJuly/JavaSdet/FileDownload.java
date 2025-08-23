package com.wiproJuly.JavaSdet;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {
	public static void main(String[] args) throws InterruptedException {
ChromeOptions co=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(co);
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		WebElement filedownload=driver.findElement(By.xpath("//a[normalize-space()='example.txt']"));
		filedownload.click();
		
		//download the text file
		
		File f=new File("\"C:\\Users\\Dell\\Downloads\\example.txt\"");
		//check the file is existing in the folder or not
		
		if(f.exists()) {
			System.out.println("The file is present ");
		}else {
			System.out.println("The file is not present ");
		}
		
		
		
	}

}
