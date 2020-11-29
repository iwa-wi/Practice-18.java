package calcTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.googleSearch;

import static org.junit.Assert.assertEquals;


public class Tests {

    private static WebDriver driver;
    private static pages.googleSearch googleSearch;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        googleSearch = new googleSearch(driver);
    }

    @Test
    public void Test1() {
        driver.get("http://google.com");
        googleSearch.search("Calculator");
        driver.findElement(By.cssSelector("div.jlkklc")).sendKeys("(1+2)*3-40/5", Keys.ENTER);
        assertEquals("(1+2)*3-40/5", driver.findElement(By.cssSelector("span.vUGUtc")));
        assertEquals(1, driver.findElement(By.cssSelector("#cwos.qv3Wpe")));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
