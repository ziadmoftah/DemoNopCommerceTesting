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

    public void userRegistration(String firstName , String lastName , String email , String password ){
        firstNameTextBox.sendKeys(firstName);
        lastNameTextBox.sendKeys(lastName);
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        confirmPasswordTextBox.sendKeys(password);
        registerBtn.click();
    }
}
