package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Listeners.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utilities;

public class Page {

	public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringDecorator e_driver;
	//public static WebEventListener eventListener;
	public static WebEventListener webEventListener;
	
	//public OptionsManager optionsManager;
	
	//public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/*public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	private void setDriver(RemoteWebDriver remoteWebDriver) {
		tldriver.set(remoteWebDriver);
	   }*/
	
	/*public Page(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/
	
	@BeforeMethod
	@Parameters("browser")
	public void initialization(String browser) throws MalformedURLException{
		//String browserName = prop.getProperty("browser");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(browser.equals("chrome")){
			//cap.setCapability("browser", "chrome");
			cap.setBrowserName("chrome");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setCapability("browser", "chrome");
			//tldriver.set(new ChromeDriver());
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src/test//resources//executable//chromedriver.exe");
			//driver = new RemoteWebDriver(new URL("http://localhost:4445"),chromeOptions);
			
			
			//WebDriverManager.chromedriver().setup();
			//tldriver.set(new ChromeDriver());
			//driver = new ChromeDriver(); 
			System.out.println("Launching chrome");
		}
		else if(browser.equals("firefox")){
			//cap.setCapability("browser", "chrome");
			cap.setBrowserName("firefox");
			//FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setCapability("browser", "firefox");
			//tldriver.set(new FirefoxDriver());
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src/test//resources//executable//geckodriver.exe");
			//driver=new RemoteWebDriver(new URL("http://localhost:4445"),firefoxOptions);
			
			//driver= new RemoteWebDriver(new URL(prop.getProperty("huburl")),firefoxOptions);
			
			//WebDriverManager.firefoxdriver().setup();	
			//driver = new FirefoxDriver(); 
			//driver.set(new FirefoxDriver());
			System.out.println("Launching firefox");
			
		}
		
		
		//webEventListener = new WebEventListener();
		//e_driver = new EventFiringWebDriver(driver);
		//e_driver = new EventFiringDecorator((WebEventListener)driver);

		//Now create object of EventListerHandler to register it with EventFiringWebDriver
		//eventListener = new WebEventListener();
		//e_driver.createDecorated(driver);
		//driver = e_driver;
		driver = new RemoteWebDriver(new URL("http://smitapal22:zalenium2024@34.44.56.157/wd/hub"), cap);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(Constants.testurl);
		driver.manage().deleteAllCookies();
		//getDriver().get(prop.getProperty("url"));
		
	}
	/*public WebDriver init_driver(Properties prop) {
		String browsername = prop.getProperty("browser");
		System.out.println("Browser Name is: "+browsername);
		optionsManager = new OptionsManager(prop);
		if (browsername.equalsIgnoreCase("chrome")) {
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browsername);
			} else {
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browsername);
			} else {
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}
		}
		else if(browsername.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}
		/*String browserName = null;
		if (System.getProperty("browser") == null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");
		}

		System.out.println("Running on ----> " + browserName + " browser");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println(browserName + " is not found, please pass the right browser Name");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();

	}

	/**
	 * 
	 * @return this method returns properties - prop available in
	 *         config.proerties file
	 */
/*	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			if (env == null) {
				path = "./src/main/java/com/qa/hubspot/config/config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "./src/main/java/com/qa/hubspot/config/config.qa.properties";
					break;
				case "stg":
					path = "./src/main/java/com/qa/hubspot/config/config.stg.properties";
					break;
				case "prod":
					path = "./src/main/java/com/qa/hubspot/config/config.properties";
					break;
				default:
					System.out.println("no env is passed");
					break;
				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not foubd.....");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}*/

	/*private WebDriver init_remoteWebDriver(String browserName) {
		//String remoteUrl ="";
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setCapability("browserName", "chrome");
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), chromeOptions));
			} catch(MalformedURLException e) {
				e.printStackTrace();
			}
		}else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("browserName", "firefox");
			//DesiredCapabilities cap = DesiredCapabilities.firefox();
			//cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getFirefoxOptions());
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), firefoxOptions));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
	}*/
	
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
		driver.quit();
		
		}
	}
}
