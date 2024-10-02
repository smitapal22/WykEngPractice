package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Page;
import Base.Page1;


public class MenuPage extends Page1 {
	public MenuPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}
	public final static int TIMEOUT = 30;
	
	//@FindAll( {
		   //@FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/section/div/div[1]/div[2]/button[2]/span"),
		   @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div[2]/section/div/div[2]/div[1]/button/span")
		//} )
	public WebElement signInOrRegister;
	@FindAll( {
		   @FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/section/div/div[1]/div[2]/button[3]/img"),
		   @FindBy(how=How.XPATH,using="//*[@id='root']/div[2]/section/div/div[1]/div[2]/button[3]/img")
		} )
	public WebElement settingsOption;
	@FindAll( {
		   @FindBy(how=How.XPATH,using="//a[@href='/en/static/contact-en']"),
		   @FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/section/div/div[2]/a[4]/div/span")
		} )
	public WebElement contactUsOption;
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/section/div/div[3]/a[4]/div/span")
	public WebElement clickOnContactUsOption;

	public SigninOrRegisterPage clickOnSigninOrRegisterOption() {
		WebElement signin = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/section/div/div[2]/div[1]/button/span")));
		signin.click();
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
				contactUsOption);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnContactUsOption);

	}

}
