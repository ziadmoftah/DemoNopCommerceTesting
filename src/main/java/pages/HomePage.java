package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;

import static utilities.BrowserInteractions.*;

import java.util.List;

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
    @FindBy(id = "ui-id-1")
    List<WebElement> autoCompleteSearchResults ;
    @FindBy(xpath = "//a[text() = 'Contact us']")
    WebElement contactUsLink ;
    @FindBy(id = "customerCurrency")
    public WebElement currencyDropDownMenu ;
    public void openRegistrationPage(){
        waitAndClickOnWebElement(registerLink , wait , driver);
    }
    public void openLogInPage(){
        waitAndClickOnWebElement(logInLink, wait, driver);
    }
    public void logOut() {
        waitAndClickOnWebElement(logOutLink , wait , driver);
    }
    public boolean isUserLoggedIn(){
        return waitAndFindIfWebElementIsVisible(logOutLink , wait) ;
    }
    public void openMyAccountPage(){
        waitAndClickOnWebElement(myAccountLink , wait , driver);
    }
    public boolean isUserLoggedOut(){
        return waitAndFindIfWebElementIsVisible(registerLink , wait);
    }
    public void searchForProduct(String product){
        waitClearAndEnterTextInTextField(searchTextBox , wait , product);
        waitAndClickOnWebElement(searchButton , wait , driver);
    }
    public void selectSearchAutoCompleteResult(String searchText){
        waitClearAndEnterTextInTextField(searchTextBox, wait , searchText);
        waitAndClickOnWebElement(autoCompleteSearchResults.get(0) , wait , driver);
    }
    public void openContactUsPage(){
        waitAndClickOnWebElement(contactUsLink , wait , driver);
    }

    public void changeCurrency(Object currency){
        waitAndSelectFromDropDownMenu(currencyDropDownMenu , wait , Constants.SELECT_BY_VISIBLE_TEXT , currency);
    }
    public String getCurrentCurrency(){
        return waitAndGetTheSelectedOptionFromDropDownMenu(currencyDropDownMenu , wait) ;
    }

}
