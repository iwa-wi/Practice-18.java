package calcTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalcPage;
import pages.googleSearch;

import static org.junit.Assert.assertEquals;


public class Tests {

    private static WebDriver driver;
    private static pages.googleSearch googleSearch;
    private static pages.CalcPage CalcPage;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        googleSearch = new googleSearch(driver);
        CalcPage = new CalcPage(driver);
    }

    @Test
    public void Test1() {
        driver.get("http://google.com");
        googleSearch.search("Calculator");
        driver.findElement(By.cssSelector("div.jlkklc")).sendKeys("(1+2)*3-40/5", Keys.ENTER);
        Assertions.assertAll(
                () -> assertEquals("(1+2)*3-40/5", CalcPage.getHistory()),
                () -> assertEquals("1", CalcPage.getResults())
        );
    }


}
