package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver ;
    @BeforeMethod
    public void startDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver() ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS) ;
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void stopDriver(){
        driver.quit();
    }

}
