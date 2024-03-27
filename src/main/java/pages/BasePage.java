package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver ;
    protected WebDriverWait wait ;
    protected JavascriptExecutor jse ;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
        jse = (JavascriptExecutor) this.driver ;
        wait = new WebDriverWait(driver , 10) ;
    }
    protected void scrollToBottom(){
        jse.executeScript("scrollBy(0, 2500)") ;
    }
}
