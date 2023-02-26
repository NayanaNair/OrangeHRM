

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage extends TestBase{

	//Page Factory or Object Repository

	@FindBy(xpath="//p[text()='Paul Collings']")
	WebElement userNameLabel;

	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;

	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;

	@FindBy(xpath="//span[text()='Leave']")
	WebElement leaveLink;

	//Initializing Page objects:

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:
	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public AdminPage clickOnadminLink() {
		adminLink.click();
		return new AdminPage();
	}
	
	public PimPage clickOnpimLink() {
		pimLink.click();
		return new PimPage();
	}
	
	public LeavePage clickOnleaveLink() {
		leaveLink.click();
		return new LeavePage();
	}


}