package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "span.vUGUtc")
    private WebElement history;

    @FindBy(css = "#cwos.qv3Wpe")
    private WebElement results;

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

    public String getHistory() {
        return history.getText();
    }

    public String getResults() {
        return results.getText();
    }
}
