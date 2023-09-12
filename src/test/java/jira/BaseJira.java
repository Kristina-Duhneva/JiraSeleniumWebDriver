package jira;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BaseJira {
    public static WebDriver driver;
    private static String username = "email";
    private static String password = "password";

    @AfterAll
    public static void classTearDown() {
        driver.close();
    }

    @BeforeAll
    public static void classSetup() {
        // Setup browser
        driver = staticBrowser(BrowserTypes.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Navigate to URL of a created project
       // "https://test-process-qa.atlassian.net/jira/software/c/projects/SEL/issues"
        driver.get("https://test-process-qa.atlassian.net/jira/software/c/projects/SEL/issues");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        usernameField.sendKeys(username);
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='login-submit']"));
        submitButton.click();
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        submitButton.click();
        WebElement createButton = driver.findElement(By.xpath("//button[@id='createGlobalItem']"));
        createButton.click();
    }
    private static WebDriver staticBrowser(BrowserTypes browserTypes) {
        switch (browserTypes) {
            case CHROME:
                return new ChromeDriver();
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                return new FirefoxDriver();
            case FIREFOX_HEADLESS:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);
        }
        return null;
    }

}
