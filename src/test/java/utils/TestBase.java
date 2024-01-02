package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("QAUrl");
		
		String browser_properties = properties.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//use ternary operator to differentiate between running script from IDE or CMD through Maven
		//result = testConditions ? value1 : value2
		//if test conditions is true, value1 will run, if false value2 will run
		String browser = browser_maven != null ? browser_maven : browser_properties;
		
		if(driver == null) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			
			//substitute, instead of using thread.sleep in our script
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.get(url);
		}
		
		return driver;
	}
}
