package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.LoggerHelper;

public class TestngTestCaseLog4j {
	private static final Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    @Test
    public void login() throws InterruptedException {
        
        log.info("Starting login test...");

        ChromeOptions chromeOption = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOption);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        log.info("Opened browser and navigated to saucedemo");

        Thread.sleep(2000);

        // Enter text in username
        WebElement username = driver.findElement(By.name("user-name"));
        username.sendKeys("standard_user");
        log.info("Entered username");

        Thread.sleep(2000);

        // Enter text in password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        log.info("Entered password");

        Thread.sleep(2000);

        // Click on login button
        WebElement login_button = driver.findElement(By.xpath("//input[@type='submit']"));
        login_button.click();
        log.info("Clicked login button");

        Thread.sleep(2000);
        driver.quit();
        log.info("Browser closed");
    }

}
