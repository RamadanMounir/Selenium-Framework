package setUp;

import home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Helper;
import utils.WindowManager;

import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    private String URL = "https://demo.nopcommerce.com/";
    public static WebDriver driver;

    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdfjs.disabled", true);
        return option;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        return options;
    }
    protected HomePage homePageObj;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(chromeOption());
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(firefoxOption());
        }

    }
    @BeforeTest
    public void goHome(){
        getWindowManager().goTo(URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePageObj = new HomePage(driver);
    }
    @BeforeClass
    public HomePage Arrange(){
        return homePageObj = new HomePage(driver);
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot.......");
            Helper.captureScreenshot(driver,result.getName());
        }


    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }


    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
