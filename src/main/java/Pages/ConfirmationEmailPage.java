package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmationEmailPage {

	@FindBy(how=How.XPATH,using="")
	public WebElement emailConfirmationText;
	
}
