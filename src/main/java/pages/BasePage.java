package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver ;
    protected JavascriptExecutor jse ;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
        jse = (JavascriptExecutor) this.driver ;
    }

    protected static void clickOnButton(WebElement btn){
        btn.click();
    }

    protected static void enterTextInTextField(WebElement textField , String text){
        textField.sendKeys(text);
    }

    protected void scrollToBottom(){
        jse.executeScript("scrollBy(0, 2500)") ;
    }
}
