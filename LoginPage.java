

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository
	
		@FindBy(xpath="//input[@name='username']")
		WebElement username;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//div[@id='app']/div[1]/div/div[1]/div/div[1]/img")
		WebElement orangeHRLogo;
		
		@FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']/p")
		WebElement loginError;
		
		@FindBy(xpath="//p[text()='Forgot your password? ']")
		WebElement forgotPasswordLink;
		
		//Initializing Page objects:
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		public boolean validateOrangeHRLogo() {
			return orangeHRLogo.isDisplayed();
		}
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public DashboardPage login(String un, String pwd ) throws InterruptedException {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return new DashboardPage();
		}
		
		public boolean isErrorMessageDisplayed() {
			return loginError.isDisplayed();
			
		}
		
		public ResetPasswordPage clickOnForgotPasswordLink() {

			forgotPasswordLink.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return new ResetPasswordPage();
		}
		
		
		
}