package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition{
	
	TestContextSetup testContextSetup;
	String productQuantity, cartProductName;
	public LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		testContextSetup.driver = new ChromeDriver();
//		testContextSetup.driver.manage().window().maximize();
//		
//		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Assert.assertTrue(landingPage.getTitlePage().contains("GreenKart"));
	}
	
	@When("User searched with shortname {string} and extract the actual name of the product")
	public void user_searched_with_shortname_and_extract_the_actual_name_of_the_product(String name) throws InterruptedException{

		landingPage.searchItem(name);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(500);
		
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		//testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from landingPage");
		Thread.sleep(1000);
	}
	
	//for scenario outline
	//delete this
	@When("^User searched with shortname (.+) and extract the actual name of the product outline$")
	public void user_searched_with_shortname_and_extract_the_actual_name_of_the_product_outline(String name) throws InterruptedException {
		landingPage.searchItem(name);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(500);
		
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		//testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from landingPage");
		Thread.sleep(1000);
		
	}
	
	//assignment
	@When("^User searched with shortname (.+) and extract the actual name of the product assignment$")
	public void user_searched_with_shortname_and_extract_the_actual_name_of_the_product_assignment(String name) throws InterruptedException {
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(name);
		Thread.sleep(500);
		
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from landingPage");
		Thread.sleep(1000);
	}
	
	@When("^User add (.+) items of the selected product to the cart$")
	public void user_add_items_of_the_selected_product_to_the_cart(String quantity) throws InterruptedException{
		productQuantity	= landingPage.inputProductQuantity(quantity);
	}
	
	@Then("^User checkout the product and validate the (.+) and quantity of the product in checkout page$")
	public void user_checkout_the_product_and_validate_the_tom_and_quantity_of_the_product_in_checkout_page(String name) throws InterruptedException {
		landingPage.addToCart();
		landingPage.openCart();
		landingPage.proceedToCheckout();
		Thread.sleep(2000);
		
		CheckoutPage checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		testContextSetup.finalProductQuantity = checkoutPage.checkQuantity();
		
		System.out.println(productQuantity + " quantity from landingPage is the same with " + testContextSetup.finalProductQuantity + " quantity from cartPage");
		Assert.assertEquals(productQuantity, testContextSetup.finalProductQuantity);
		
		cartProductName = checkoutPage.getProductName().split("-")[0].trim();
		System.out.println(cartProductName + " is extracted from cartPage");
		
		System.out.println(cartProductName + " from cartPage is the same with " + testContextSetup.landingPageProductName + " from landingPage");
		Assert.assertEquals(cartProductName, testContextSetup.landingPageProductName);
		
	}
	
}
