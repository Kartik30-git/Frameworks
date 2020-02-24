package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class Base {
	static WebDriver driver;  //driver should be made static as it should have the same copy for each class using it.
	Properties prop = new Properties();
	public WebDriver initializeDriver() throws IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kartik\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		String driverPath = "C:\\Users\\kartik\\Downloads\\Automation Software\\Drivers\\";
		if (browserName.equalsIgnoreCase("chrome")) {
			// Setup Chrome
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Open FF
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			// Open IE
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public void getScreenshot(String testName) throws IOException {
		File 	src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C://test//screenshot"+testName+".png"));
	}
}
