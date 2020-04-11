import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestRegistration extends RegistrationPageObject {

	WebDriver driver;
//	RegistrationPageObject registry = new RegistrationPageObject();

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test (priority = 0)
	public void registerOneAccount() {
		driver.get(REGISTRATION_URL);
		createAccount(driver, "looda10@yahoo.com", "Marijana", "Magdalena", "MMagdalena123!", "Marija", "Magdalena", "Ribolovacka 142", "AlaskaCity", "Alaska", "10000", "475844575647", "pibolovac");
		driver.navigate().to(MYACCOUNT_URL);
		Assert.assertEquals(registeredName(driver), "Marijana Magdalena");
		
	}

	@Test(priority = 1)
	public void register30Accounts() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src\\test\\java\\MOCK_DATA.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
			driver.get(REGISTRATION_URL);
			create30Account(driver, sheet);
			Thread.sleep(2000);
	}

	@AfterClass
	public void closeSite() {
		driver.quit();
	}

}
