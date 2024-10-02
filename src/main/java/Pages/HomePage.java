package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;
import Base.Page1;

public class HomePage extends Page1{
	
	public HomePage() {
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	@FindAll( {
		   @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div[2]/header/div/div[3]/div[2]/button"),
		   @FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/header/div/div[1]/div[1]/button")
		} )
	public WebElement enLanguage;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"wzrk-cancel\"]")
	public WebElement noThanksBtn;
	//@FindBy({
		   //@FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/div[2]/div/div/div/div[4]/div[1]/button"),
	@FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[4]/div[1]/button")
	//})
	public WebElement acceptAllBtn;
	//@FindAll( {
		   //@FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/header/div/div[1]/button[1]/img"),
		   @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div[2]/header/div/div[3]/button[2]/img")
		//} )
	public WebElement menuBtn;
	//@FindAll( {
		  // @FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/header/div/div[1]/button[2]/span"),
	 @FindBy(how=How.XPATH,using="//button[@class='btn subscribe-btn']")
		//} )
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
