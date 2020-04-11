import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLogin extends LoginPageObject{
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority = 0)
	public void loginTest() {
		driver.get(LOGIN_URL);
		login(driver, "looda9@yahoo.com", "MMagdalena123!");
		driver.navigate().to(MYACCOUNT_URL);
		Assert.assertEquals(loginName(driver), "Marijana Magdalena");
	}

	@AfterClass
	public void closeSite() {
		driver.quit();
	}


}
