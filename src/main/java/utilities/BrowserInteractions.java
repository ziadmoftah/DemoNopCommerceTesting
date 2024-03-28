package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserInteractions {
    public static void printException(Exception e , String methodName){
        System.out.println( "Exception while " + methodName + " Method :" + e.getMessage());
        e.printStackTrace();
    }
    public static void waitAndClickOnWebElement(WebElement webElement , WebDriverWait wait , WebDriver driver){
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
        catch (Exception e){
            printException(e, new Object(){}.getClass().getEnclosingMethod().getName() );
        }
    }
    public static void waitClearAndEnterTextInTextField(WebElement webElement , WebDriverWait wait , String text){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch (Exception e){
            printException(e, new Object(){}.getClass().getEnclosingMethod().getName() );
        }
    }
    public static String waitAndGetTextFromWebElement(WebElement webElement , WebDriverWait wait ){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.getText();
        }
        catch (Exception e){
            printException(e, new Object(){}.getClass().getEnclosingMethod().getName() );
            return null ;
        }
    }
    public static boolean waitAndFindIfWebElementIsVisible(WebElement webElement , WebDriverWait wait){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement)) ;
            return true ;
        }
        catch (Exception e ){
            printException(e ,new Object(){}.getClass().getEnclosingMethod().getName());
            return false;
        }
    }
}
