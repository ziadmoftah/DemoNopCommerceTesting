package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

public class SearchProductsByAutoComplete extends BaseTest{
    HomePage homePage ;
    ProductDetailsPage productDetailsPage ;
    String productName = "Apple MacBook Pro 13-inch" ;

    @Test
    public void userCanSearchForProductByUsingAutoComplete(){
        homePage = new HomePage(driver) ;
        homePage.selectSearchAutoCompleteResult("mac");
        productDetailsPage = new ProductDetailsPage(driver) ;
        Assert.assertTrue(productDetailsPage.getProductName().getText().equalsIgnoreCase(productName));
    }
}
