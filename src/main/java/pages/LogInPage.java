package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        enterTextInTextField(emailTextBox,email);
        enterTextInTextField(passwordTextBox,password);
        clickOnButton(logInBtn);
    }

}
