

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminPage extends TestBase{

	//Page Factory or Object Repository

	@FindBy(xpath="//h6[text()='Admin']")
	WebElement adminLabel;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement username;

	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	WebElement userRole;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath="//button[@type='button' and text()=' Reset ']")
	WebElement resetBtn;
	
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement yesDeleteBtn;

	Actions a = new Actions(driver);

	//Initializing Page objects:

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions:

	public boolean verifyAdminLabel() {
		return adminLabel.isDisplayed();
	}

	public AdminPage searchUserByUsername(String un) {
		username.sendKeys(un);
		submitBtn.click();
		return new AdminPage();


	}

	public AdminPage searchUserByUserRole() throws InterruptedException {

		userRole.click();
		a.moveToElement(userRole).moveByOffset(0, 65).pause(Duration.ofSeconds(3)).contextClick().pause(Duration.ofSeconds(3)).build().perform();
		
		
		Thread.sleep(3000);
		submitBtn.click();

		return new AdminPage();


	}

	public AdminPage resetSearchUser() {
		resetBtn.click();
		return new AdminPage();


	}
	
	
	public void selectContactsByName(String name) {
		
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='"+name+"']//parent::div//..//div[@class='oxd-table-cell oxd-padding-cell']"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		checkbox.click();
	}
	
	public void deleteContactsByName(String name) {
		
		WebElement deleteBtn = driver.findElement(By.xpath("(//div[text()='"+name+"']//parent::div//..//div[@class='oxd-table-cell oxd-padding-cell'])[6]//descendant::i[@class='oxd-icon bi-trash']"));
		
		deleteBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		yesDeleteBtn.click();
		
	}


}