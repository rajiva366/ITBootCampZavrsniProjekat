import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class RegistrationPageObject {

	public static String REGISTRATION_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
	public static String MYACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
	WebDriverWait wait;
	WebElement textRegister;
	FileInputStream fileExcel;

	public void createAccount(WebDriver driver, String email, String firstname, String lastname, String password,
			String firstnameAddress, String lastnameAddress, String address, String city, String state, String zipcode,
			String mobile, String addressAliace) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
		WebElement emailcreate = driver.findElement(By.id("email_create"));
		emailcreate.sendKeys(email);
		WebElement btnCreateAcc = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"));
		btnCreateAcc.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		WebElement fn = driver.findElement(By.id("customer_firstname"));
		fn.sendKeys(firstname);
		WebElement ln = driver.findElement(By.id("customer_lastname"));
		ln.sendKeys(lastname);
		WebElement passw = driver.findElement(By.id("passwd"));
		passw.sendKeys(password);
		WebElement fnAddress = driver.findElement(By.id("firstname"));
		fnAddress.sendKeys(firstnameAddress);
		WebElement lnAddress = driver.findElement(By.id("lastname"));
		lnAddress.sendKeys(lastnameAddress);
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys(address);
		WebElement city1 = driver.findElement(By.id("city"));
		city1.sendKeys(city);
		Select state1 = new Select(driver.findElement(By.cssSelector("select#id_state")));
		state1.selectByVisibleText(state);
		WebElement zip = driver.findElement(By.id("postcode"));
		zip.sendKeys(String.valueOf(zipcode));
		WebElement mPhone = driver.findElement(By.id("phone_mobile"));
		mPhone.sendKeys(String.valueOf(mobile));
		WebElement address1Aliace = driver.findElement(By.id("alias"));
		address1Aliace.sendKeys(addressAliace);
		WebElement btnRegister = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span"));
		btnRegister.click();
	}

	public String registeredName(WebDriver driver) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")));
		textRegister = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span"));
		return textRegister.getText();

	}

	public void create30Account(WebDriver driver, Sheet sheet) throws IOException {
		SoftAssert sa = new SoftAssert();
		Row row;
		for (int i = 1; i < sheet.getLastRowNum(); i++) {

			row = sheet.getRow(i);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
			WebElement emailcreate = driver.findElement(By.id("email_create"));
			emailcreate.sendKeys(row.getCell(1).toString());
			WebElement btnCreateAcc = driver.findElement(
					By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"));
			btnCreateAcc.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
			WebElement fn = driver.findElement(By.id("customer_firstname"));
			fn.sendKeys(row.getCell(2).toString());
			WebElement ln = driver.findElement(By.id("customer_lastname"));
			ln.sendKeys(row.getCell(3).toString());
			WebElement passw = driver.findElement(By.id("passwd"));
			passw.sendKeys(row.getCell(4).toString());
			WebElement fnAddress = driver.findElement(By.id("firstname"));
			fnAddress.sendKeys(row.getCell(5).toString());
			WebElement lnAddress = driver.findElement(By.id("lastname"));
			lnAddress.sendKeys(row.getCell(6).toString());
			WebElement address1 = driver.findElement(By.id("address1"));
			address1.sendKeys(row.getCell(7).toString());
			WebElement city1 = driver.findElement(By.id("city"));
			city1.sendKeys(row.getCell(8).toString());
			Select state1 = new Select(driver.findElement(By.cssSelector("select#id_state")));
			state1.selectByVisibleText(row.getCell(9).toString());
			WebElement zip = driver.findElement(By.id("postcode"));
			int zip_code = (int) row.getCell(10).getNumericCellValue();
			zip.sendKeys(String.valueOf(zip_code));
			WebElement mPhone = driver.findElement(By.id("phone_mobile"));
			int mobi = (int) row.getCell(11).getNumericCellValue();
			mPhone.sendKeys(String.valueOf(mobi));
			WebElement address1Aliace = driver.findElement(By.id("alias"));
			address1Aliace.sendKeys(row.getCell(12).toString());
			WebElement btnRegister = driver
					.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span"));
			btnRegister.click();
			driver.navigate().to(MYACCOUNT_URL);

			sa.assertEquals(registeredName(driver), row.getCell(2).toString() + " " + row.getCell(3).toString());
			logOut(driver);
		}
		sa.assertAll();
	}

	public void logOut(WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")));
		WebElement logOut = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
		logOut.click();
	}

}
