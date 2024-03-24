package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        clickOnButton(changePasswordLink);
    }
    public void changePassword(String oldPassword, String newPassword){
        enterTextInTextField(oldPasswordTextBox , oldPassword);
        enterTextInTextField(newPasswordTextBox , newPassword);
        enterTextInTextField(confirmNewPasswordTextBox , newPassword);
        clickOnButton(changePasswordButton);
    }
    public boolean isPasswordChangedSuccessfully(){
        return notificationBarLabel.getText().equals("Password was changed") ;
    }
    public void closeNotificationBarCloseButton(){
        clickOnButton(notificationBarCloseButton);
    }
}
