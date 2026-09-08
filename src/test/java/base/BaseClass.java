package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
     public void setUp()
    {
    	// Default run chrome
        String browser = System.getProperty("browser", "chrome");

        System.out.println("Browser: " + browser);

        switch (browser.toLowerCase()) {

        case "chrome":

            ChromeOptions chromeOptions = new ChromeOptions();

            // Headless works in Jenkins and also works in Eclipse
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(chromeOptions);
            break;

        case "firefox":

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            // Jenkins runs as a Windows service
            firefoxOptions.addArguments("-headless");

            driver = new FirefoxDriver(firefoxOptions);
            break;

        case "edge":

            EdgeOptions edgeOptions = new EdgeOptions();

            // Jenkins runs as a Windows service
            edgeOptions.addArguments("--headless=new");
            edgeOptions.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(edgeOptions);
            break;

        default:

            throw new IllegalArgumentException(
                    "Invalid browser: " + browser +
                    ". Use chrome, firefox, or edge."
            );
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.google.com");
    }

  
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}