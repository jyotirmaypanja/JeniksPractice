package com.capstoneProject.HealthCare;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsValidationTest {
    WebDriver driver;
    Actions actions;
    private final String BASE = "https://westfloridaahec.org";

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        // small startup pause
        Thread.sleep(800);
    }

    @Test(priority = 1)
    public void validateContactUsPageFromNavigators() throws InterruptedException {
        // 1) open navigators page (starting point)
        driver.get(BASE + "/navigators/");
        Thread.sleep(1500);

        // 2) close cookie popup if present (inline)
        try {
            WebElement agree = driver.findElement(By.xpath("//*[contains(text(),'Agree') or contains(text(),'ACCEPT') or contains(text(),'Accept') or contains(text(),'Allow')]"));
            if (agree.isDisplayed()) {
                try { agree.click(); Thread.sleep(400); } catch (Exception ignored) {}
            }
        } catch (NoSuchElementException ignored) {}

        // 3) locate top "CONTACT US" nav link and click it
        WebElement contactNav = null;
        try { contactNav = driver.findElement(By.linkText("CONTACT US")); } catch (Exception ignored) {}
        if (contactNav == null) {
            try { contactNav = driver.findElement(By.linkText("Contact Us")); } catch (Exception ignored) {}
        }
        // fallback: use partial matching via xpath if label variants exist
        if (contactNav == null) {
            try { contactNav = driver.findElement(By.xpath("//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact us') or contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'contact')]")); } catch (Exception ignored) {}
        }
        Assert.assertNotNull(contactNav, "CONTACT US nav link was not found on the navigators page");
        contactNav.click();
        Thread.sleep(1200);

        // 4) validate current URL is contact-us
        String current = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(current.startsWith(BASE + "/contact-us/"), "Expected to be on Contact Us page. Current URL: " + current);

        // 5) Validate page heading contains "Contact" or "Contact Us"
        boolean headingOk = false;
        try {
            WebElement heading = driver.findElement(By.xpath("//h1 | //h2"));
            if (heading != null && heading.getText() != null) {
                String ht = heading.getText().toLowerCase();
                headingOk = ht.contains("contact");
            }
        } catch (Exception ignored) {}
        Assert.assertTrue(headingOk, "Contact Us page heading did not contain expected text 'contact'.");

        // 6) Validate address presence (look for a likely address snippet)
        boolean addressFound = false;
        try {
            // try common page blocks (address may be inside icons & text)
            WebElement addressEl = driver.findElement(By.xpath("//*[contains(translate(.,'ADDRESS','address'),'address')]/following::p[1] | //*[contains(@class,'address') or contains(@class,'contact-address')]"));
            if (addressEl != null && addressEl.getText() != null && addressEl.getText().trim().length() > 5) {
                addressFound = true;
            }
        } catch (Exception ignored) {}
        Assert.assertTrue(addressFound, "Address block not found or empty on Contact Us page.");

        // 7) Validate phone number presence (search simple phone pattern)
        boolean phoneFound = false;
        try {
            WebElement phoneEl = driver.findElement(By.xpath("//*[contains(.,'(850') or contains(.,'(850)') or contains(.,'682-2552') or contains(.,'682.2552') or contains(@href,'tel:')]"));
            if (phoneEl != null && phoneEl.getText() != null && phoneEl.getText().trim().length() > 3) phoneFound = true;
        } catch (Exception ignored) {}
        Assert.assertTrue(phoneFound, "Phone number not found on Contact Us page (expected (850) 682-2552 or a tel: link).");

        // 8) Validate email link presence and clickable
        boolean emailFound = false;
        try {
            WebElement emailEl = null;
            try { emailEl = driver.findElement(By.xpath("//a[contains(@href,'mailto:') and (contains(translate(.,'EMAIL','email'),'email') or contains(@href,'mailto:'))]")); } catch (Exception ignored) {}
            if (emailEl == null) {
                // fallback: find any anchor with 'info@' or 'wfahec' in href/text
                try { emailEl = driver.findElement(By.xpath("//a[contains(translate(@href,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'mailto:info') or contains(translate(.,'INFO@','info@'),'info@')]")); } catch (Exception ignored) {}
            }
            if (emailEl != null) {
                emailFound = true;
                String href = emailEl.getAttribute("href");
                // click the email link to ensure it's present (it may open mail client; we only check href)
                try {
                    emailEl.click();
                    Thread.sleep(500);
                } catch (Exception ignored) {}
                Assert.assertTrue(href != null && href.toLowerCase().startsWith("mailto:"), "Email anchor exists but href is not mailto: -> " + href);
            }
        } catch (Exception ignored) {}
        Assert.assertTrue(emailFound, "Email link (mailto:) not found on Contact Us page.");

        // 9) Basic content check
        Assert.assertTrue(driver.getPageSource().length() > 200, "Contact Us page seems very small — page source length low.");

        System.out.println("Contact Us validations passed (URL, heading, address, phone, email).");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(400);
        if (driver != null) driver.quit();
    }
}