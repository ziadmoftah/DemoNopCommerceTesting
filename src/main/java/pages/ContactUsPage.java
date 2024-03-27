package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utilities.BrowserInteractions.*;


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
        waitClearAndEnterTextInTextField(fullNameTextField , wait , fullName);
        waitClearAndEnterTextInTextField(emailTextField , wait , email);
        waitClearAndEnterTextInTextField(enquiryTextArea , wait , enquiry);
        waitAndClickOnWebElement(submitButton , wait);

    }
    public boolean isEnquirySuccessfullySent(){
        String  message = waitAndGetTextFromWebElement(successMessage , wait) ;
        if ( message == null){
            return false ;
        }
        if ( message.equals("Your enquiry has been successfully sent to the store owner.")){
            return true ;
        }
        return false ;
    }
}
