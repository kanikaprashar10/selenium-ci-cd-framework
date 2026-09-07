package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
     public void setUp() 
    {
    	 String browser = System.getProperty("browser","chrome");
    	 System.out.println("Browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) 
        {	
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } 
        else if (browser.equalsIgnoreCase("firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } 
        else if (browser.equalsIgnoreCase("edge")) 
        {
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } 
        else {
            System.out.println("Browser not supported: " + browser);
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