import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
	
	public static String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static String MYACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
	WebElement emailLogin;
	WebElement passwordLogin;
	WebElement btnSignin;
	WebElement textRegister;
	WebDriverWait wait;
	
	public void login (WebDriver driver, String email, String password) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")));	
		emailLogin =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input"));
		emailLogin.sendKeys(email);
		passwordLogin = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input"));
		passwordLogin.sendKeys(password);
		btnSignin = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span"));
		btnSignin.click();
	}
	
	public String loginName (WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")));	
		textRegister = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span"));
		return textRegister.getText();

	}

}
