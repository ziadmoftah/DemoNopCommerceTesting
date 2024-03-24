package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div.product-name")
    WebElement productName ;

    public WebElement getProductName() {
        return productName;
    }
}
