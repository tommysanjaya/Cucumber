package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	By quantityProduct = By.xpath("//input[@value='1']");
	By addToCartButton = By.xpath("//button[normalize-space()='ADD TO CART']");
	By cartButton = By.xpath("//img[@alt='Cart']");
	By checkoutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
		
	public String getTitlePage() {
		return driver.getTitle();
	}
	
	public void searchItem(String name) {
		driver.findElement(Search).sendKeys(name);
	}
	
	public void getSearchText(String name) {
		driver.findElement(Search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public String inputProductQuantity(String quantity) {
		driver.findElement(quantityProduct).sendKeys(Keys.BACK_SPACE);
		driver.findElement(quantityProduct).sendKeys(quantity);
		return quantity;
	}
	
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
	
	public void openCart() {
		driver.findElement(cartButton).click();
	}
	
	public void proceedToCheckout() {
		driver.findElement(checkoutButton).click();
	}
}
