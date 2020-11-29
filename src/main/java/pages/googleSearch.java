package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class googleSearch {

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement searchBar;

    public googleSearch(WebDriver driver) {
        initElements(driver, this);
    }

    public void search(String text) {
        searchBar.sendKeys(text, Keys.ENTER);
    }
}
