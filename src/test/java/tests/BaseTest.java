package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver ;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("firefox") String browserName){
        if ( browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver() ;
        }
        else if ( browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver() ;
        }
        else if ( browserName.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver() ;
        }
        else {
            System.out.println("Problem with initializing browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS) ;
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

    // take screenshot when test fails and add it in the screenshot folder
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result){
        if (  result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(driver, result.getName());
        }
    }


}
