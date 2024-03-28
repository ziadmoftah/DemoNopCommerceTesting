package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchProductResultsPage;

public class SearchProductTest extends BaseTest{
    HomePage homePage ;
    SearchProductResultsPage searchProductResultsPage ;
    ProductDetailsPage productDetailsPage ;
    String productName = "Apple MacBook Pro 13-inch" ;
    @Test
    public void userCanSearchForSpecificProduct(){
        homePage= new HomePage(driver);
        homePage.searchForProduct(productName);
        searchProductResultsPage=new SearchProductResultsPage(driver);
        searchProductResultsPage.openProductDetails();
        productDetailsPage= new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.getProductName().equalsIgnoreCase(productName));
    }
}
