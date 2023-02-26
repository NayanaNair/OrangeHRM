

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ResetPasswordPage extends TestBase{

	//Page Factory or Object Repository

	@FindBy(xpath="//input[@name='username']")
	WebElement username;

	@FindBy(xpath="//button[text()=' Cancel ']")
	WebElement cancelBtn;

	@FindBy(xpath="//button[text()=' Reset Password ']")
	WebElement resetPasswordBtn;

	//Initializing Page objects:

	public ResetPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public ResetPasswordPage resetPassword(String un) {
		username.sendKeys(un);
		resetPasswordBtn.click();
		return new ResetPasswordPage();
	}
	
	public LoginPage resetPasswordCancel(String un) {
		username.sendKeys(un);
		cancelBtn.click();
		return new LoginPage();
	}


}