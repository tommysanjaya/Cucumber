package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	public WebDriver driver;
	public WebDriver wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By quantity = By.xpath("//p[@class='quantity']");
	By productName = By.xpath("//p[@class='product-name']");
	By promoCodeField = By.xpath("//input[@placeholder='Enter promo code']");
	By applyButton = By.xpath("//button[@class='promoBtn']");
	By alert = By.xpath("//span[@class='promoInfo']");
	By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
	
	public String checkQuantity() {
		String totalQuantity = driver.findElement(quantity).getText();
		return totalQuantity;
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void usePromoCode(String promoCode) {
		driver.findElement(promoCodeField).sendKeys(promoCode);
		driver.findElement(applyButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String promoCodeResult = wait.until(ExpectedConditions.presenceOfElementLocated(alert)).getText();
		System.out.println(promoCodeResult);
	}
	
	public void placeOrder() {
		driver.findElement(placeOrderButton).click();
	}
	
	
}
