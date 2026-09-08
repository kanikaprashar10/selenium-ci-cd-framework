package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
    	
    	//mvn clean test -Dbrowser=chrome --------on terminal
    	//String browser = System.getProperty("browser","chrome");

        if (browser.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

  
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}