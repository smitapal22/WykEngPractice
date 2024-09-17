package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;


public class MenuPage extends Page {
	public MenuPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}
	public final static int TIMEOUT = 30;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div[2]/section/div/div[1]/div[2]/button[2]/span")
	public WebElement signInOrRegister;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"root\\\"]/div[2]/section/div/div[1]/div[2]/button[3]/img")
	public WebElement settingsOption;
	@FindBy(how = How.XPATH, using = "//a[@href='/en/static/contact-en']")
	public WebElement contactUsOption;
	@FindBy(how = How.XPATH, using = "//a[@href='/en/static/contact-en']")
	public WebElement clickOnContactUsOption;

	public SigninOrRegisterPage clickOnSigninOrRegisterOption() {
		signInOrRegister.click();
		return new SigninOrRegisterPage();
	}

	public void clickOnSettingsOption() {
		settingsOption.click();
	}

	/*public void clickOnContactUs() {
		contactUsOption.click();

	}*/

	public void clickOnContactUs() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
		clickOnContactUsOption);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnContactUsOption);

	}

}
