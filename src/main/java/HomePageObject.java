import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

	

	public static String HOME_URL = "http://automationpractice.com/index.php";

	public void mouseOnWomen(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement mouseOnWomen = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		action.moveToElement(mouseOnWomen).perform();
	}
	
	public String clickOnSummerDressFromWoman(WebDriver driver) {
		WebElement clickSummerDress = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a"));
		clickSummerDress.click();
		String uRLFromWomen = driver.getCurrentUrl();
		return uRLFromWomen;
	}
	
	public void mouseOnDresses(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement mouseOnDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		action.moveToElement(mouseOnDresses).perform();
	}
	
	public String clickOnSummerDressFromDressess(WebDriver driver) {
		WebElement clickSummerDress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"));
		clickSummerDress.click();
		String uRLFromDresses = driver.getCurrentUrl();
		return uRLFromDresses;
	}

}
