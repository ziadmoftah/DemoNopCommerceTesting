package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest{
    HomePage homePage ;
    ContactUsPage contactUsPage ;
    String fullName = "ziad" ;
    String email = "sa@test.com";
    String enquiry = "hello this is a test" ;
    @Test
    public void userCanSendEnquirySuccessfully(){
        homePage = new HomePage(driver) ;
        homePage.openContactUsPage();
        contactUsPage= new ContactUsPage(driver);
        contactUsPage.contactUs(fullName , email,enquiry);
        Assert.assertTrue(contactUsPage.isEnquirySuccessfullySent());
    }
}
