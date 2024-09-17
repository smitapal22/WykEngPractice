package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;

public class HomePage extends Page{
	
	public HomePage() {
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div[2]/header/div/div[1]/div[1]/button")
	public WebElement enLanguage;
	@FindBy(how=How.XPATH,using="//div[@class='wzrk-button-container']/button[@id='wzrk-cancel']")
	public WebElement noThanksBtn;
	@FindBy(how=How.XPATH,using="//button[text()='Accept All']")
	public WebElement acceptAllBtn;
	@FindBy(how=How.XPATH,using="//button[@class='btn menu-icon']")
	public WebElement menuBtn;
	@FindBy(how=How.XPATH,using="//button[@class='btn subscribe-btn']")
	public WebElement subscribeBtn;
	
	
	public void clickOnEnBtn() {
		enLanguage.click();
	}
	public void clickOnnoThanksBtn() {
		noThanksBtn.click();
	}
	public void clickOnAcceptAll() {
		acceptAllBtn.click();
	}
	public MenuPage clickOnMenuBtn() {
		menuBtn.click();
		return new MenuPage();
	}
	

}
