package com.capstoneProject.HealthCare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Tests:
 *  - Hover PROGRAMS -> click each program page
 *  - Validate page header contains program name
 *  - Find a program-specific resource link inside the main article content (keyword-based)
 *  - Click that resource link and assert navigation happened and page contains content
 *
 * Style: inline, Thread.sleep-based waits (no helpers, no explicit waits).
 */
public class ProgramPagesClickableResourcesTest {
    WebDriver driver;
    Actions actions;
    private final String BASE = "https://westfloridaahec.org";

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        Thread.sleep(800); // let browser warm up
    }

    private void tryCloseCookiePopupInline() {
        try {
            WebElement agree = driver.findElement(By.xpath("//*[contains(text(),'Agree') or contains(text(),'ACCEPT') or contains(text(),'Accept') or contains(text(),'Allow')]"));
            if (agree.isDisplayed()) {
                try { agree.click(); Thread.sleep(400); } catch (Exception ignored) {}
            }
        } catch (NoSuchElementException ignored) {}
    }

    @Test(priority = 1)
    public void validateTobaccoAndResourceClickable() throws InterruptedException {
        driver.get(BASE + "/navigators/");
        Thread.sleep(1500);
        tryCloseCookiePopupInline();

        // hover PROGRAMS
        WebElement programs = null;
        try { programs = driver.findElement(By.linkText("PROGRAMS")); } catch (Exception ignored) {}
        if (programs == null) {
            try { programs = driver.findElement(By.linkText("Programs")); } catch (Exception ignored) {}
        }
        Assert.assertNotNull(programs, "PROGRAMS menu not found");
        actions.moveToElement(programs).perform();
        Thread.sleep(800);

        // click Tobacco
        WebElement tobacco = null;
        try { tobacco = driver.findElement(By.linkText("Tobacco")); } catch (Exception ignored) {}
        Assert.assertNotNull(tobacco, "Tobacco link not found under PROGRAMS");
        tobacco.click();
        Thread.sleep(1400);

        // check header contains 'Tobacco'
        boolean headerOk = false;
        try {
            WebElement h = driver.findElement(By.xpath("//h1|//h2"));
            headerOk = h.getText().toLowerCase().contains("tobacco");
        } catch (Exception ignored) {}
        Assert.assertTrue(headerOk, "Page header should contain 'Tobacco'");

        // find a program-related resource link inside main content (search anchors for 'tobacco' or 'contact' or 'learn')
        List<WebElement> anchors = driver.findElements(By.xpath("//main//a | //article//a | //div[contains(@class,'entry') or contains(@class,'content')]//a"));
        WebElement candidate = null;
        for (WebElement a : anchors) {
            try {
                String txt = (a.getText() != null ? a.getText().toLowerCase() : "");
                String href = (a.getAttribute("href") != null ? a.getAttribute("href").toLowerCase() : "");
                if (txt.contains("tobacco") || href.contains("tobacco") || txt.contains("learn") || href.contains("learn") || txt.contains("contact") || href.contains("contact")) {
                    candidate = a;
                    break;
                }
            } catch (Exception ignored) {}
        }
        Assert.assertNotNull(candidate, "No program-related resource link found on Tobacco page (searched main/article content).");
        String beforeUrl = driver.getCurrentUrl();
        // click candidate and validate navigation
        try { candidate.click(); } catch (Exception e) {
            // fallback: javascript click if normal click fails
            try { ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", candidate); } catch (Exception ignored) {}
        }
        Thread.sleep(1200);
        String afterUrl = driver.getCurrentUrl();
        Assert.assertFalse(afterUrl.equalsIgnoreCase(beforeUrl), "Click on resource link should navigate to a different URL.");
        Assert.assertTrue(driver.getPageSource().length() > 100, "Target page should contain enough content.");
        System.out.println("Tobacco page and resource link validated: navigated from " + beforeUrl + " -> " + afterUrl);
    }

    @Test(priority = 2)
    public void validateAHECScholarsAndResourceClickable() throws InterruptedException {
        driver.get(BASE + "/navigators/");
        Thread.sleep(1500);
        tryCloseCookiePopupInline();

        WebElement programs = null;
        try { programs = driver.findElement(By.linkText("PROGRAMS")); } catch (Exception ignored) {}
        if (programs == null) {
            try { programs = driver.findElement(By.linkText("Programs")); } catch (Exception ignored) {}
        }
        Assert.assertNotNull(programs, "PROGRAMS menu not found");
        actions.moveToElement(programs).perform();
        Thread.sleep(800);

        WebElement ahec = null;
        try { ahec = driver.findElement(By.linkText("AHEC Scholars")); } catch (Exception ignored) {}
        Assert.assertNotNull(ahec, "AHEC Scholars link not found under PROGRAMS");
        ahec.click();
        Thread.sleep(1400);

        boolean headerOk = false;
        try {
            WebElement h = driver.findElement(By.xpath("//h1|//h2"));
            headerOk = h.getText().toLowerCase().contains("ahec") || h.getText().toLowerCase().contains("scholar");
        } catch (Exception ignored) {}
        Assert.assertTrue(headerOk, "Page header should contain 'AHEC' or 'Scholars'");

        List<WebElement> anchors = driver.findElements(By.xpath("//main//a | //article//a | //div[contains(@class,'entry') or contains(@class,'content')]//a"));
        WebElement candidate = null;
        for (WebElement a : anchors) {
            try {
                String txt = (a.getText() != null ? a.getText().toLowerCase() : "");
                String href = (a.getAttribute("href") != null ? a.getAttribute("href").toLowerCase() : "");
                if (txt.contains("ahec") || href.contains("ahec") || txt.contains("scholar") || href.contains("scholar") || txt.contains("apply") || href.contains("apply")) {
                    candidate = a;
                    break;
                }
            } catch (Exception ignored) {}
        }
        Assert.assertNotNull(candidate, "No program-related resource link found on AHEC Scholars page.");
        String beforeUrl = driver.getCurrentUrl();
        try { candidate.click(); } catch (Exception e) {
            try { ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", candidate); } catch (Exception ignored) {}
        }
        Thread.sleep(1200);
        String afterUrl = driver.getCurrentUrl();
        Assert.assertFalse(afterUrl.equalsIgnoreCase(beforeUrl), "Click on AHEC resource link should navigate to a different URL.");
        Assert.assertTrue(driver.getPageSource().length() > 100, "Target page should contain enough content.");
        System.out.println("AHEC Scholars page and resource link validated: navigated from " + beforeUrl + " -> " + afterUrl);
    }

    @Test(priority = 3)
    public void validateHealthyAgingAndResourceClickable() throws InterruptedException {
        driver.get(BASE + "/navigators/");
        Thread.sleep(1500);
        tryCloseCookiePopupInline();

        WebElement programs = null;
        try { programs = driver.findElement(By.linkText("PROGRAMS")); } catch (Exception ignored) {}
        if (programs == null) {
            try { programs = driver.findElement(By.linkText("Programs")); } catch (Exception ignored) {}
        }
        Assert.assertNotNull(programs, "PROGRAMS menu not found");
        actions.moveToElement(programs).perform();
        Thread.sleep(800);

        WebElement healthy = null;
        try { healthy = driver.findElement(By.linkText("Healthy Aging")); } catch (Exception ignored) {}
        Assert.assertNotNull(healthy, "Healthy Aging link not found under PROGRAMS");
        healthy.click();
        Thread.sleep(1400);

        boolean headerOk = false;
        try {
            WebElement h = driver.findElement(By.xpath("//h1|//h2"));
            headerOk = h.getText().toLowerCase().contains("healthy") || h.getText().toLowerCase().contains("aging");
        } catch (Exception ignored) {}
        Assert.assertTrue(headerOk, "Page header should contain 'Healthy' or 'Aging'");

        List<WebElement> anchors = driver.findElements(By.xpath("//main//a | //article//a | //div[contains(@class,'entry') or contains(@class,'content')]//a"));
        WebElement candidate = null;
        for (WebElement a : anchors) {
            try {
                String txt = (a.getText() != null ? a.getText().toLowerCase() : "");
                String href = (a.getAttribute("href") != null ? a.getAttribute("href").toLowerCase() : "");
                if (txt.contains("aging") || href.contains("aging") || txt.contains("healthy") || href.contains("healthy") || txt.contains("program") || href.contains("program")) {
                    candidate = a;
                    break;
                }
            } catch (Exception ignored) {}
        }
        Assert.assertNotNull(candidate, "No program-related resource link found on Healthy Aging page.");
        String beforeUrl = driver.getCurrentUrl();
        try { candidate.click(); } catch (Exception e) {
            try { ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", candidate); } catch (Exception ignored) {}
        }
        Thread.sleep(1200);
        String afterUrl = driver.getCurrentUrl();
        Assert.assertFalse(afterUrl.equalsIgnoreCase(beforeUrl), "Click on Healthy Aging resource link should navigate to a different URL.");
        Assert.assertTrue(driver.getPageSource().length() > 100, "Target page should contain enough content.");
        System.out.println("Healthy Aging page and resource link validated: navigated from " + beforeUrl + " -> " + afterUrl);
    }

    @Test(priority = 4)
    public void validateCoveringFloridaAndResourceClickable() throws InterruptedException {
        driver.get(BASE + "/navigators/");
        Thread.sleep(1500);
        tryCloseCookiePopupInline();

        WebElement programs = null;
        try { programs = driver.findElement(By.linkText("PROGRAMS")); } catch (Exception ignored) {}
        if (programs == null) {
            try { programs = driver.findElement(By.linkText("Programs")); } catch (Exception ignored) {}
        }
        Assert.assertNotNull(programs, "PROGRAMS menu not found");
        actions.moveToElement(programs).perform();
        Thread.sleep(800);

        WebElement cover = null;
        try { cover = driver.findElement(By.linkText("Covering Florida")); } catch (Exception ignored) {}
        Assert.assertNotNull(cover, "Covering Florida link not found under PROGRAMS");
        cover.click();
        Thread.sleep(1400);

        // 1) URL check (tolerant)
        String current = driver.getCurrentUrl().toLowerCase();
        boolean urlOk = current.startsWith(BASE + "/covering-florida/") || current.startsWith(BASE + "/navigators/") || current.contains("covering");
        Assert.assertTrue(urlOk, "Covering Florida expected URL not matched. Current: " + current);

        // 2) Try header check (h1/h2)
        boolean headerOk = false;
        try {
            WebElement h = driver.findElement(By.xpath("//h1|//h2"));
            if (h != null && h.getText() != null) {
                String txt = h.getText().toLowerCase();
                if (txt.contains("cover") || txt.contains("florida") || txt.contains("navigators") || txt.contains("navigator")) {
                    headerOk = true;
                }
            }
        } catch (Exception ignored) {}

        // 3) Fallback checks if header not matching
        if (!headerOk) {
            // title
            try {
                String title = driver.getTitle() != null ? driver.getTitle().toLowerCase() : "";
                if (title.contains("cover") || title.contains("florida") || title.contains("navigator") || title.contains("navigators")) {
                    headerOk = true;
                }
            } catch (Exception ignored) {}
        }

        if (!headerOk) {
            // page body contains keywords
            try {
                String body = driver.getPageSource().toLowerCase();
                if (body.contains("covering") || body.contains("florida") || body.contains("navigator") || body.contains("find a navigator") || body.contains("navigators")) {
                    headerOk = true;
                }
            } catch (Exception ignored) {}
        }

        // If still false, collect a small snippet and fail with diagnostic to help debugging
        if (!headerOk) {
            String snippet = "";
            try {
                String src = driver.getPageSource();
                snippet = src.length() > 800 ? src.substring(0, 800) : src;
            } catch (Exception ignored) {}
            Assert.fail("Page header/title/contents did not contain expected keywords for Covering Florida. Current URL: "
                        + current + ". Page snippet: \n" + snippet);
        }

        // 4) find resource link inside main/article/content (same logic as other tests)
        List<WebElement> anchors = driver.findElements(By.xpath("//main//a | //article//a | //div[contains(@class,'entry') or contains(@class,'content')]//a"));
        WebElement candidate = null;
        for (WebElement a : anchors) {
            try {
                String txt = (a.getText() != null ? a.getText().toLowerCase() : "");
                String href = (a.getAttribute("href") != null ? a.getAttribute("href").toLowerCase() : "");
                if (txt.contains("florida") || href.contains("florida") || txt.contains("navigator") || href.contains("navigator") || txt.contains("contact") || href.contains("contact")) {
                    candidate = a;
                    break;
                }
            } catch (Exception ignored) {}
        }
        Assert.assertNotNull(candidate, "No program-related resource link found on Covering Florida page.");

        String beforeUrl = driver.getCurrentUrl();
        try { candidate.click(); } catch (Exception e) {
            try { ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", candidate); } catch (Exception ignored) {}
        }
        Thread.sleep(1200);
        String afterUrl = driver.getCurrentUrl();
        Assert.assertFalse(afterUrl.equalsIgnoreCase(beforeUrl), "Click on Covering Florida resource link should navigate to a different URL.");
        Assert.assertTrue(driver.getPageSource().length() > 100, "Target page should contain enough content.");
        System.out.println("Covering Florida page and resource link validated: navigated from " + beforeUrl + " -> " + afterUrl);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(400);
        if (driver != null) driver.quit();
    }
}