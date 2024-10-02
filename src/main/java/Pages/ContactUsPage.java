package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;
import Base.Page1;


public class ContactUsPage extends Page1 {
	
	public ContactUsPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}
	
	@FindBy(how=How.XPATH,using="//div[@class='contact-us-email']/input[@name='contact-email']")
	public WebElement contactEmailField;
	@FindAll( {
		   @FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/div/section/div/div/div[2]/div[2]/select-box/div/div/div[1]"),
		   @FindBy(how=How.XPATH,using="//div[text()='Subject']")
		} )
	public WebElement clickOnSubjectDropdown;
	
	@FindBy(how=How.XPATH,using="//div[@class='select-element']")
	public List<WebElement> selectValues;
	@FindAll( {
		   @FindBy(how=How.XPATH,using="//input[@class='input']"),
		   @FindBy(how=How.XPATH,using="//input[@name='mobile']")
		} )
	public WebElement contactMobileField;
	
	@FindBy(how=How.XPATH,using="//div[@class='contact-us-content']/textarea[@name='content']")
	public WebElement contentField;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn contact-us-btn']")
	public WebElement submitBtn;
	
	
	public void EnterTextInEmailField(String email) {
		//entering the text
		Actions action = new Actions(driver);
		action.moveToElement(contactEmailField).perform();
		contactEmailField.sendKeys(email);;
	}
	
	public void ClickOnSubjectDropdown() {
		clickOnSubjectDropdown.click();
	
	}
	
	public void SelectSubjectDropdown(String selectedSubjectValue) {
		
		List<WebElement>subjectdropdownValues = driver.findElements(By.xpath("//div[@class='select-element']"));
		for(WebElement subjectdropdownValue : subjectdropdownValues) {
			String values = subjectdropdownValue.getText();
			if(values.equalsIgnoreCase(selectedSubjectValue)) {
			
			System.out.println(subjectdropdownValue.getText());
			
			}
		}
	}
			
		
	
	
	public void EnterMobileNoInMobField(String mobileNo) {
		contactMobileField.sendKeys(mobileNo);
	}
	
	public void EnterTextInContentField(String description) {
		contentField.sendKeys(description);
	}
	public void ClickOnSubmitBtn() {
		submitBtn.click();
	}
	
	

}
