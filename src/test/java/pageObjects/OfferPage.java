package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Search)).sendKeys(name);
	}
	
	public void getSearchText(String name) {
		driver.findElement(Search).getText();

	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	

}
