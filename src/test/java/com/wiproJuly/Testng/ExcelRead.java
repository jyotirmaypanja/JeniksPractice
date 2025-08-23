package com.wiproJuly.Testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void login() throws IOException, InterruptedException {
		File src = new File ("F:\\java_p1\\JavaSdet\\TestData\\Testdata1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		// load the work book
		workbook = new XSSFWorkbook(fis) ;
		sheet = workbook.getSheetAt(0);
		// create a for loop to iterate in the sheet of rows and columns
		for (int i = 1; i<= sheet.getLastRowNum(); i++) {
			ChromeOptions chromeOptions = new ChromeOptions();
 
			WebDriverManager.chromedriver().setup();
 
			WebDriver driver = new ChromeDriver(chromeOptions);
 
			// launch the url
 
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			
			Thread.sleep(3000);
			
			// import  the username from the excel sheet
			cell = sheet.getRow(i).getCell(0);
			WebElement emial = driver.findElement(By.xpath("//input[@placeholder='Username']"));
			Thread.sleep(2000);
			emial.sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			cell = sheet.getRow(i).getCell(1);
			Thread.sleep(2000);
			WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			Thread.sleep(2000);
			password.sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);

			WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
			login.click();
			
			Thread.sleep(5000);
			driver.quit();

		}



	}
 

}
