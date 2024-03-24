package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends BaseTest{
    HomePage homePage ;
    UserRegistrationPage userRegistrationPage ;
    LogInPage userLogInPage ;
    String email = "test@gmail.com" ;
    String password = "123456" ;
    @Test (alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homePage = new HomePage(driver) ;
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver) ;
        userRegistrationPage.userRegistration("ziad" , "moftah" , email , password);
        Assert.assertTrue(userRegistrationPage.isUserRegisteredSuccessfully());
    }
    @Test ( dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void registeredUserCanLogInSuccessfully(){
        homePage.openLogInPage();
        userLogInPage = new LogInPage(driver) ;
        userLogInPage.userLogIn(email , password);
        Assert.assertTrue(homePage.isUserLoggedIn());
    }
}
