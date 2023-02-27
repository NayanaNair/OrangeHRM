

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip =new FileInputStream("D:\\ExcelR_Selenium_Sep7\\OrangeHRM\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "D:\ExcelR_Selenium_Sep7\OrangeHRM\src\chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(browserName.equals("Firefox")) {
				//System.setProperty("webdriver.gecko.driver", "D:\ExcelR_Selenium_Sep7\OrangeHRM\src\geckodriver.exe");
				driver = new FirefoxDriver();	
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
						
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
