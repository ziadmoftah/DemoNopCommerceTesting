package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utilities.BrowserInteractions.*;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink ;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTextBox ;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTextBox ;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordTextBox ;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordButton;

    @FindBy(xpath = "//div[@id ='bar-notification']//p")
    WebElement notificationBarLabel ;
    @FindBy ( xpath = "//div[@id ='bar-notification']//span")
    WebElement notificationBarCloseButton ;
    public void openChangePasswordPage(){
        waitAndClickOnWebElement(changePasswordLink , wait);
    }
    public void changePassword(String oldPassword, String newPassword){
        waitClearAndEnterTextInTextField(oldPasswordTextBox , wait , oldPassword);
        waitClearAndEnterTextInTextField(newPasswordTextBox, wait , newPassword);
        waitClearAndEnterTextInTextField(confirmNewPasswordTextBox , wait , newPassword);
        waitAndClickOnWebElement(changePasswordButton , wait);
    }
    public boolean isPasswordChangedSuccessfully(){
        String message = waitAndGetTextFromWebElement(notificationBarLabel , wait) ;
        if ( message == null){
            return false ;
        }
        return message.equals("Password was changed");
    }
    public void closeNotificationBarCloseButton(){
        waitAndClickOnWebElement(notificationBarCloseButton , wait );
    }
}
