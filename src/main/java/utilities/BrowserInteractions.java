package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    public static void waitAndSelectFromDropDownMenu(WebElement webElement , WebDriverWait wait, int type, Object selection){
        try {
            waitAndFindIfWebElementIsVisible(webElement , wait) ;
            Select select = new Select(webElement) ;
            if ( type == Constants.SELECT_BY_VALUE){
                select.selectByValue((String)selection);
            }
            else if ( type == Constants.SELECT_BY_INDEX){
                select.selectByIndex((Integer) selection);
            }
            else if ( type == Constants.SELECT_BY_VISIBLE_TEXT){
                select.selectByVisibleText((String)selection);
            }
        }
        catch (Exception e ){
            printException( e , new Object(){}.getClass().getEnclosingMethod().getName());
        }
    }
    public static String waitAndGetTheSelectedOptionFromDropDownMenu(WebElement webElement , WebDriverWait wait){
        try {
            waitAndFindIfWebElementIsVisible(webElement , wait) ;
            Select select = new Select(webElement) ;
            return select.getFirstSelectedOption().getText() ;
        }
        catch (Exception e){
            printException(e , new Object(){}.getClass().getEnclosingMethod().getName());
            return null;
        }
    }
    public static void waitAndHoverOverWebElement(WebElement webElement , WebDriverWait wait , WebDriver webDriver){
        try{
            waitAndFindIfWebElementIsVisible(webElement , wait) ;
            Actions action = new Actions(webDriver) ;
            action.moveToElement(webElement).perform();
        }
        catch (Exception e){
            printException(e , new Object(){}.getClass().getEnclosingMethod().getName());
        }
    }

}
