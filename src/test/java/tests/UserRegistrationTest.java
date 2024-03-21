package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends BaseTest{
    HomePage homePage ;
    UserRegistrationPage userRegistrationPage ;
    @Test
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver) ;
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver) ;
        userRegistrationPage.userRegistration("ziad" , "moftah" , "test1@gmail.com" , "123456");
        Assert.assertTrue(userRegistrationPage.isUserRegisteredSuccessfully());
    }
}
