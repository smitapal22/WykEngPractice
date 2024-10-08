package TestCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Page;
import Pages.HomePage;
import Pages.MenuPage;
import Pages.SigninOrRegisterPage;
import utilities.Utilities;




public class SigninTest extends Page {
	String sheetName = "LoginTest";
	HomePage homePage;
	MenuPage menuPage;
	SigninOrRegisterPage signinOrRegisterPage;
	Utilities utils;
	
	
	public SigninTest(){
		//HomePage homePage;
		super();
	}
	
	@BeforeMethod
	public void settingUp() throws InterruptedException, MalformedURLException{
		
		initialization();
		//utils = new Utilities();
		//init_driver(prop);
		
		//Utilities.runTimeInfo("error", "login successful");
		//Utilities.switchToFrame();
		homePage = new HomePage();
		menuPage = new MenuPage();
		signinOrRegisterPage = new SigninOrRegisterPage();
		
	}
	/*@DataProvider
	public Object[][] getData(){
		Object data[][] = Utilities.getexData(sheetName);
		return data;
	}*/
	
	//@Test(dataProvider="getData")
	@Test(dataProviderClass=Utilities.class,dataProvider="getData")
	public void InvalidUserTest(String username,String password) throws InterruptedException {
		
		homePage.clickOnEnBtn();
		homePage.clickOnnoThanksBtn();
		homePage.clickOnAcceptAll();
		homePage.clickOnMenuBtn();
		menuPage.clickOnSigninOrRegisterOption();
		signinOrRegisterPage.doLogin(username, password);
		
		String actualTextforInvalidUser = driver
				.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[@class='Toastify__toast-body']")).getText();
		//div[@class='wzrk-button-container']/button[@id='wzrk-cancel']
		System.out.println("Actual invalid email toast msg: "+actualTextforInvalidUser);
		System.out.println("Ending");
		Thread.sleep(5000);
		String expextedTextforInvalidUser = "Invalid email or password";
		Assert.assertEquals(actualTextforInvalidUser, expextedTextforInvalidUser);
		
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="getData")
	public void ValidUserTest(String username, String password) {
		homePage.clickOnEnBtn();
		homePage.clickOnnoThanksBtn();
		homePage.clickOnAcceptAll();
		homePage.clickOnMenuBtn();
		menuPage.clickOnSigninOrRegisterOption();
		signinOrRegisterPage.doLogin(username, password);
		homePage.clickOnMenuBtn();
		String validUserdomain = driver.findElement(By.xpath("//span[contains(text(),'@maildrop.cc')]")).getText();
		//String validUserdomain = driver.findElement(By.xpath("//*[ends-with(text(),'@maildrop.cc')]")).getText();
		String expecteduserdomain = "iosa50@maildrop.cc";
		Assert.assertEquals(validUserdomain, expecteduserdomain);
		
	}
	
	//ValidUserTest
	@AfterMethod
	public void tearDown(){
		if(driver!=null) {
		driver.quit();
		}
	}
	
	}


