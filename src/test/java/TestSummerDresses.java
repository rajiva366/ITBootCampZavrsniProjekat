import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestSummerDresses {

	WebDriver driver;
	SummerDressesPageObject summerd = new SummerDressesPageObject();

	@BeforeClass
	public void openSummerdressesURL() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority = 0)
	public void pickFirstSummerDress() {
		driver.get(SummerDressesPageObject.SUMMERDRESSES_URL);
		summerd.pickDress(driver);
		System.out.println(driver.getCurrentUrl());
		
		String acctuaURS = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index";
		
		Assert.assertTrue(acctuaURS.contains(expectedURL));;
	}

//	@Test (priority = 1)
//	public void chooseParametersFirstDress() {
//		driver.get(SummerDressesPageObject.FIRSTDRESS_URL);
//		summerd.chooseTwoDresses(driver);
//		summerd.chooseM(driver);
//		summerd.chooseBlue(driver);
//		summerd.addToCard(driver);
//		summerd.ProceedChackout(driver);
//		summerd.checkCard(driver);
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(summerd.checkTitle.getText(), "Printed Summer Dress");
//		sa.assertEquals(summerd.checkNumber.getText(), "2 Products");
//		sa.assertEquals(summerd.checkColorSize.getText(), "Color : Blue, Size : M");
//		sa.assertAll();
//		
//	}

	@AfterClass
	public void closeSite() {
		driver.quit();
	}

}
