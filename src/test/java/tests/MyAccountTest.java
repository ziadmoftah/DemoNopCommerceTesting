package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends BaseTest{
    HomePage homePage ;
    LogInPage userLogInPage ;

    MyAccountPage myAccountPage ;
    String email = "test@gmail.com" ;
    String oldPassword = "12345678999";
    String newPassword = "123456789999" ;

    @Test ( alwaysRun = true)
    public void registeredUserCanLogInSuccessfully(){
        homePage = new HomePage(driver) ;
        homePage.openLogInPage();
        userLogInPage = new LogInPage(driver) ;
        userLogInPage.userLogIn(email , oldPassword);
        Assert.assertTrue(homePage.isUserLoggedIn());
    }
    @Test (dependsOnMethods = {"registeredUserCanLogInSuccessfully"})
    public void registeredUserCanChangePasswordSuccessfully(){
        homePage.openMyAccountPage();
        myAccountPage=  new MyAccountPage(driver) ;
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(oldPassword , newPassword);
        Assert.assertTrue(myAccountPage.isPasswordChangedSuccessfully());

    }
    @Test (dependsOnMethods = {"registeredUserCanChangePasswordSuccessfully"})
    public void closeNotificationBar(){
        myAccountPage.closeNotificationBarCloseButton();
    }
    @Test (dependsOnMethods = {"closeNotificationBar"})
    public void userLogOutSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        homePage.logOut();
        Assert.assertTrue(homePage.isUserLoggedOut());
    }
    @Test (dependsOnMethods = {"userLogOutSuccessfully"})
    public void registeredUserCanLogInSuccessfullyAfterChangingPassword(){
        homePage.openLogInPage();
        userLogInPage.userLogIn(email , newPassword);
        Assert.assertTrue(homePage.isUserLoggedIn());

    }
}
