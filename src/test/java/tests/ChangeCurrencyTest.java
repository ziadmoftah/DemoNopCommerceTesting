package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends BaseTest{
    HomePage homePage ;
    String currency = "Euro" ;
    ProductDetailsPage productDetailsPage ;
    @Test
    public void UserCanChangeCurrencySuccessfully()  {
        homePage = new HomePage(driver) ;
        homePage.changeCurrency(currency);
        Assert.assertEquals(homePage.getCurrentCurrency() , currency);
        homePage.selectSearchAutoCompleteResult("mac");
        productDetailsPage = new ProductDetailsPage(driver) ;
        Assert.assertTrue(productDetailsPage.getProductPrice().contains("€"));
    }



}
