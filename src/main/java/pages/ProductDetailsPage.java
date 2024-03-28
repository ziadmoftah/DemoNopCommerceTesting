package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utilities.BrowserInteractions.*;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div.product-name")
    WebElement productName ;
    @FindBy(id = "price-value-4")
    WebElement productPrice ;
    public String getProductName() {
        return waitAndGetTextFromWebElement(productName , wait);
    }
    public String getProductPrice(){
        return waitAndGetTextFromWebElement(productPrice , wait) ;
    }
}
