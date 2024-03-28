package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utilities.BrowserInteractions.*;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement emailTextBox ;

    @FindBy(id ="Password")
    WebElement passwordTextBox;

    @FindBy(css = "button.login-button")
    WebElement logInBtn ;

    public void userLogIn(String email , String password){
        waitClearAndEnterTextInTextField(emailTextBox , wait , email);
        waitClearAndEnterTextInTextField(passwordTextBox ,wait , password);
        waitAndClickOnWebElement(logInBtn , wait , driver);
    }

}
