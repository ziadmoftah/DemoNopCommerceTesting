package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utilities.BrowserInteractions.*;

public class UserRegistrationPage extends BasePage{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FirstName")
    WebElement firstNameTextBox;

    @FindBy(id = "LastName")
    WebElement lastNameTextBox ;

    @FindBy(id = "Email")
    WebElement emailTextBox ;

    @FindBy(id = "Password")
    WebElement passwordTextBox ;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTextBox ;

    @FindBy(id = "register-button")
    WebElement registerBtn ;

    @FindBy(className = "result")
    WebElement successMessage ;

    public void userRegistration(String firstName , String lastName , String email , String password ){
        waitClearAndEnterTextInTextField(firstNameTextBox , wait , firstName);
        waitClearAndEnterTextInTextField(lastNameTextBox , wait , lastName);
        waitClearAndEnterTextInTextField(emailTextBox , wait , email);
        waitClearAndEnterTextInTextField(passwordTextBox , wait , password);
        waitClearAndEnterTextInTextField(confirmPasswordTextBox , wait , password);
        waitAndClickOnWebElement(registerBtn , wait);
    }
    public boolean isUserRegisteredSuccessfully(){
        String message = waitAndGetTextFromWebElement(successMessage , wait) ;
        if ( message == null){
            return false ;
        }
        return message.equals("Your registration completed");
    }
}
