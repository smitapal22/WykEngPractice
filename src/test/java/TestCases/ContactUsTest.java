package TestCases;

import java.net.MalformedURLException;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Page;
import Base.Page1;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.MenuPage;
import Pages.SigninOrRegisterPage;


public class ContactUsTest extends Page1{
	//WebDriver driver;
	HomePage homePage;
	MenuPage menuPage;
	//SigninOrRegisterPage signinOrRegisterPage;
	ContactUsPage contactUsPage;
	SigninOrRegisterPage signinOrRegisterPage;
	
	
	
	/*public ContactUsTest() {
		super();
	}*/
	/*@BeforeMethod
	public void settingUp(){
		initialization("browser");
		//utils = new Utilities();
		//init_driver(prop);
		//Utilities.runTimeInfo("error", "login successful");
		//Utilities.switchToFrame();
		homePage = new HomePage();
		menuPage = new MenuPage();
		contactUsPage = new ContactUsPage();
	}*/
	
	@Test()
	public void contactTest() {
		HomePage homePage = new HomePage();
		MenuPage menuPage = new MenuPage();
		//SigninOrRegisterPage signinOrRegisterPage = new SigninOrRegisterPage();
		/*homePage.clickOnEnBtn();
		homePage.clickOnnoThanksBtn();
		homePage.clickOnAcceptAll();
		homePage.clickOnMenuBtn();
		menuPage.clickOnSigninOrRegisterOption();
		signinOrRegisterPage.doLogin(username, password);
		homePage.clickOnMenuBtn();*/
		SigninTest.ValidUserTest("iosa22@maildrop.cc","12345678");
		//homePage.clickOnMenuBtn();
		menuPage.clickOnContactUs();
		contactUsPage.EnterTextInEmailField("iosa22@maildrop.cc");
		contactUsPage.ClickOnSubjectDropdown();
		contactUsPage.SelectSubjectDropdown("Data Privacy Enquiry / Request");
		contactUsPage.EnterMobileNoInMobField("8676487678");
		contactUsPage.EnterTextInContentField("Test");
		contactUsPage.ClickOnSubmitBtn();
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.);
		
	    WebElement toastElement = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Thank you for contacting weyyak! we will be in touch with you shortly.']")));
	    String toastMessage = toastElement.getText();
	   // String expectedToastMessage = "Thank you for contacting weyyak! we will be in touch with you shortly.";
	    if (toastMessage.equals("Thank you for contacting weyyak! we will be in touch with you shortly.")) {
	        System.out.println("Toast message verified: " + toastMessage);
	    } else {
	        System.out.println("Unexpected toast message: " + toastMessage);
	    }

	    // Wait for the toast message to disappear
	    new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(toastElement));
}
		
	

}


