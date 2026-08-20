package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
    public void setUp(String browser) 
    {
        //driver = new ChromeDriver();
		
		browser = System.getProperty("browser");
		
		System.out.println("=================================");
		System.out.println("Browser being used: " + browser);
		System.out.println("=================================");

		if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Browser not supported: " + browser);
        }
		
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
    }

	@AfterMethod
    public void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
