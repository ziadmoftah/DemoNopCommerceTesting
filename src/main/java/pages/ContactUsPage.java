package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
    WebElement fullNameTextField;
    @FindBy(id = "Email")
    WebElement emailTextField;
    @FindBy(id = "Enquiry")
    WebElement enquiryTextArea;
    @FindBy(xpath = "//button[@class ='button-1 contact-us-button']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class = 'result']")
    WebElement successMessage ;
    public void contactUs(String fullName, String email, String enquiry){
        enterTextInTextField(fullNameTextField , fullName);
        enterTextInTextField(emailTextField, email);
        enterTextInTextField(enquiryTextArea , enquiry);
        clickOnButton(submitButton);
    }
    public boolean isEnquirySuccessfullySent(){
        return successMessage.getText().equals("Your enquiry has been successfully sent to the store owner.") ;
    }
}
