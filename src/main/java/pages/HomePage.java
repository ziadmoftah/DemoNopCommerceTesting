package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink ;
    @FindBy (linkText = "Log in")
    WebElement logInLink ;
    @FindBy(linkText = "Log out")
    WebElement logOutLink;
    @FindBy(linkText = "My account")
    WebElement myAccountLink ;
    @FindBy(id = "small-searchterms")
    WebElement searchTextBox ;
    @FindBy (css = "button.button-1.search-box-button")
    WebElement searchButton ;
    public void openRegistrationPage(){
        clickOnButton(registerLink);
    }
    public void openLogInPage(){
        clickOnButton(logInLink);
    }
    public void logOut() {
        clickOnButton(logOutLink);
    }
    public boolean isUserLoggedIn(){
        return logOutLink.isDisplayed() ;
    }
    public void openMyAccountPage(){
        clickOnButton(myAccountLink);
    }
    public boolean isUserLoggedOut(){
        return registerLink.isDisplayed() ;
    }
    public void searchForProduct(String product){
        enterTextInTextField(searchTextBox,product);
        clickOnButton(searchButton);
    }

}
