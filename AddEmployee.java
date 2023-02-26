


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddEmployeePage extends TestBase{
	
	//Page Factory or Object Repository
	
	

			@FindBy(xpath="//input[@name='firstName']")
			WebElement firstName;
			
			@FindBy(xpath="//input[@name='middleName']")
			WebElement middleName;
			
			@FindBy(xpath="//input[@name='lastName']")
			WebElement lastName;
			
			@FindBy(xpath="//button[text()=' Save ']")
			WebElement submitBtn;
			
			@FindBy(xpath="//button[text()=' Cancel ']")
			WebElement cancelBtn;

			//Initializing Page objects:

			public AddEmployeePage() {
				PageFactory.initElements(driver, this);
			}

			//Actions:
			
			public PersonalDetailsPage addNewEmployee(String ftName, String mdName, String ltName ) {
				
				firstName.sendKeys(ftName);
				middleName.sendKeys(mdName);
				lastName.sendKeys(ltName);
				
				submitBtn.click();
				
				return new PersonalDetailsPage();
			}

}