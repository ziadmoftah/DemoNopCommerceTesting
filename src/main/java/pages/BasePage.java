package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver ;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    protected static void clickOnBtn(WebElement btn){
        btn.click();
    }

    protected static void enterTextInTextField(WebElement textField , String text){
        textField.sendKeys(text);
    }
}
