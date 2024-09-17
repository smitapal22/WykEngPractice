package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;

public class SigninOrRegisterPage extends Page{
	
public SigninOrRegisterPage() {
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
	PageFactory.initElements(factory, this);
}
	@FindBy(how=How.XPATH,using="//input[@class='input email-phone']")
	public WebElement emailorMobileField;
	@FindBy(how=How.XPATH,using="//input[@class='input password']")
	public WebElement passwordField;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-confirm']")
	public WebElement continueBtn;
	//@FindBy(how=How.XPATH,using="")
	//public WebElement registerBtn;
	@FindBy(how=How.XPATH,using="//div[@class='Toastify__toast Toastify__toast--success']")
	////*[contains(text(),'Invalid email or password')]
	//div[@class='Toastify__toast Toastify__toast--success']
	public WebElement invalidEmailOrPhoneToastMsg;
	
	
	public void EnterEmailorMobileinField(String username) {
		//emailorMobileField.click();
		emailorMobileField.sendKeys(username);
	}
	
	public void EnterPasswordinPasswordField(String password) {
		//passwordField.click();
		passwordField.sendKeys(password);
	}
	public void clickOnContinueBtn() {
		continueBtn.click();
	}
	//public void clickOnRegsiterBtn() {
	//	registerBtn.click();
	//}
	public void verifyInvalidEmailorPhoneToastMeg() {
		String invalidEmailOrPhoneToast =invalidEmailOrPhoneToastMsg.getText();
	}
	
	public void doLogin(String username,String password) {
	emailorMobileField.sendKeys(username);
	passwordField.sendKeys(password);
	continueBtn.click();
	}
}
