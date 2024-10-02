package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;
import Base.Page1;

public class SigninOrRegisterPage extends Page1 {

	public SigninOrRegisterPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	//@FindAll({ 
		@FindBy(how = How.XPATH, using = "//input[@name='email']")
	//}
			//@FindBy(how = How.XPATH, using = "//input[@class='input email-phone']") })
	public WebElement emailorMobileField;
	//@FindAll({ @FindBy(how = How.XPATH, using = "//input[@name='password']"),
			@FindBy(how = How.XPATH, using = "//input[@name='password']") 
			//})
	public WebElement passwordField;
	//@FindAll({
		//	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/section/div/div/div[1]/div[1]/div[2]/button/span"),
			@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/div/section/div/div/div[1]/div[1]/div[2]/button/span")
			//})
	public WebElement continueBtn;
	// @FindBy(how=How.XPATH,using="")
	// public WebElement registerBtn;
	//@FindAll({ 
	//	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div/div/div[1]"),
			@FindBy(how = How.XPATH, using = "//div[@class='Toastify__toast Toastify__toast--success']") 
			//})
	public WebElement invalidEmailOrPhoneToastMsg;

	//// *[contains(text(),'Invalid email or password']
	// div[@class='Toastify__toast Toastify__toast--success']

	public void EnterEmailorMobileinField(String username) {
		// emailorMobileField.click();
		emailorMobileField.sendKeys(username);
	}

	public void EnterPasswordinPasswordField(String password) {
		// passwordField.click();
		passwordField.sendKeys(password);
	}

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	// public void clickOnRegsiterBtn() {
	// registerBtn.click();
	// }
	public void verifyInvalidEmailorPhoneToastMeg() {
		String invalidEmailOrPhoneToast = invalidEmailOrPhoneToastMsg.getText();
	}

	public void doLogin(String username, String password) {
		emailorMobileField.sendKeys(username);
		passwordField.sendKeys(password);
		continueBtn.click();
	}
}
