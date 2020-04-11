import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesPageObject {
	
	public static String SUMMERDRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static String FIRSTDRESS_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";
	WebDriverWait wait;
	WebElement firstDress;
	WebElement twoDresses;
	Select sizeM;
	WebElement blue;
	WebElement checkTitle;
	WebElement checkNumber;
	WebElement checkColorSize;
	
	
	public void pickDress (WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")));
		firstDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
		firstDress.click();
	}
	
	
	public void chooseTwoDresses (WebDriver driver){
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='quantity_wanted']")));
		twoDresses = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
		twoDresses.clear();
		twoDresses.sendKeys("2");

	}
	
	public void chooseM(WebDriver driver) {
		sizeM = new Select(driver.findElement(By.cssSelector("select#group_1")));
		sizeM.selectByVisibleText("M");	
	}
	
	public void chooseBlue(WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("color_14")));
		blue = driver.findElement(By.id("color_14"));
		blue.click();
		
	}
	
	public void addToCard(WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit")));
		WebElement addToCardBtn = driver.findElement(By.name("Submit"));
		addToCardBtn.click();
	}
	
	public void ProceedChackout (WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
		WebElement proceedBtn = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		proceedBtn.click();
		
	}
	
	public void checkCard (WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/small[2]/a")));
		checkColorSize = driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/small[2]/a"));
		checkTitle=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a"));
		checkNumber = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1/span/span"));
		
		
	}
	
}
