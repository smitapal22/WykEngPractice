package Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page1 {
	
	public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	/*public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}*/
	
	@BeforeMethod
	@Parameters("browser")
	public void initialization(String browser) throws MalformedURLException {
		//DesiredCapabilities cap = new DesiredCapabilities();
		if(browser.equalsIgnoreCase("chrome")) {
			//cap.setCapability("browser", "chrome");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setCapability("browser", "chrome");
			//chromeOptions.setCapability("browserVersion", "128.0.6613.120" );
			//driver= new RemoteWebDriver(new URL("http://192.168.168.0.9:4445/wd/hub"),chromeOptions);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Launching Chrome");
		}
		if(browser.equalsIgnoreCase("firefox")) {
			//cap.setCapability("browser", "firefox");
			//FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setCapability("browser", "firefox");
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src/test//resources//executable//geckodriver.exe");
			//driver= new RemoteWebDriver(new URL("http://192.168.168.0.9:4445/wd/hub"),firefoxOptions);
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("Launching firefox");
		}
		//driver = new RemoteWebDriver(new URL("http://localhost:4445"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT ,TimeUnit.SECONDS);
		driver.get(Constants.testurl);
	}
	
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
