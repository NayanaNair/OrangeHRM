

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PimPage extends TestBase{
	
	//Page Factory or Object Repository
	
	

		@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
		WebElement addBtn;
		
		@FindBy(xpath="//h6[text()='PIM']")
		WebElement pimLabel;

		//Initializing Page objects:

		public PimPage() {
			PageFactory.initElements(driver, this);
		}

		//Actions:

		public boolean verifyPimLabel() {
			return pimLabel.isDisplayed();
		}

		
		
		public AddEmployeePage clickAddButton() {
			addBtn.click();
			
			return new AddEmployeePage();
			
		}

}