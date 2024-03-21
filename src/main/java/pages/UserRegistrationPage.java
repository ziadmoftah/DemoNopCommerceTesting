package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        enterTextInTextField(firstNameTextBox,firstName);
        enterTextInTextField(lastNameTextBox,lastName);
        enterTextInTextField(emailTextBox,email);
        enterTextInTextField(passwordTextBox , password);
        enterTextInTextField(confirmPasswordTextBox,password);
        clickOnBtn(registerBtn);
    }
    public boolean isUserRegisteredSuccessfully(){
        return successMessage.getText().equals("Your registration completed") ;
    }
}
