package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductResultsPage extends BasePage{

    public SearchProductResultsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[ @class = 'product-title']//a[1]")
    WebElement productLink ;
    public void openProductDetails(){
        clickOnButton(productLink);
    }
}
