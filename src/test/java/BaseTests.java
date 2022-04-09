import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected FactorialCalculatorPage factorialCalculatorPage;
    protected WebDriverWait wait;
    protected WebDriver driver;

  @BeforeSuite
    public void setUp() throws IOException {
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");

        // Start in Incognito mode
        EdgeOptions options = new EdgeOptions();
        options.setCapability("InPrivate", true);

        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://z29vzcbmaw5kaw5nigzvcib5b3u.prospace.io/");

        factorialCalculatorPage = new FactorialCalculatorPage(driver, wait);

        // Make the browser fullscreen - is optional
        driver.manage().window().maximize();
}

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
