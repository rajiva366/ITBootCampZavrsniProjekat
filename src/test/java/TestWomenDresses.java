import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestWomenDresses {

	WebDriver driver;
	HomePageObject home = new HomePageObject();
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test (priority = 0)
	public void clickOnSummerDressesfromWomen() {
		driver.get(HomePageObject.HOME_URL);
		home.mouseOnWomen(driver);
		home.clickOnSummerDressFromWoman(driver);
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";

		Assert.assertEquals(currentURL, expectedURL);
	}
	
	@Test (priority = 1)
	public void clickOnSummerDressesfromDressess() {
		driver.get(HomePageObject.HOME_URL);
		home.mouseOnDresses(driver);
		home.clickOnSummerDressFromDressess(driver);
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?id_category=11&controller=category";

		Assert.assertEquals(currentURL, expectedURL);
	}
	
	@Test (priority=2)
	public void equalityURLFromWomenAndDressess() {
		driver.get(HomePageObject.HOME_URL);
		home.mouseOnWomen(driver);
		String fromWomen = home.clickOnSummerDressFromWoman(driver);
		home.mouseOnDresses(driver);
		String fromDresses =home.clickOnSummerDressFromDressess(driver);
		
		Assert.assertEquals(fromWomen, fromDresses);
	}

	

	@AfterClass
	public void closeSite() {
		driver.quit();
	}

}
