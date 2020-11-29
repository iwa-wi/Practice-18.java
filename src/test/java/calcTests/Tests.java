package calcTests;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver.get("http://google.com");
        googleSearch.search("Calculator");
    }

    @Test
    @DisplayName("Операции с целыми числами")
    public void Test1() {
        CalcPage.count("(1+2)*3-40/5");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cwos.qv3Wpe")));
        Assertions.assertAll(
                () -> assertEquals("(1 + 2) \u00d7 3 - 40 \u00f7 5 =", CalcPage.getHistory()),
                () -> assertEquals("1", CalcPage.getResults())
        );
    }

    @Test
    @DisplayName("Деление на ноль")
    public void Test2() {
        CalcPage.count("6/0");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cwos.qv3Wpe")));
        Assertions.assertAll(
                () -> assertEquals("6 \u00f7 0 =", CalcPage.getHistory()),
                () -> assertEquals("Infinity", CalcPage.getResults())
        );
    }

    @Test
    @DisplayName("Ошибка при пустом значении")
    public void Test3() {
        CalcPage.count("sin");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cwos.qv3Wpe")));
        Assertions.assertAll(
                () -> assertEquals("sin() =", CalcPage.getHistory()),
                () -> assertEquals("Error", CalcPage.getResults())
        );
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
