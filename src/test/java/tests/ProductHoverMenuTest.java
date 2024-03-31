package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductHoverMenuTest extends BaseTest{
    HomePage homePage ;

    @Test
    public void userCanSelectSubCategoryFromMainMenu() {
        homePage = new HomePage(driver) ;
        homePage.openDesktopsPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
    }
}
