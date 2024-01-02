package stepDefinitions;

import java.util.Iterator;
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
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition{
	
	TestContextSetup testContextSetup;
	String offerPageProductName;
	PageObjectManager pageObjectManager;
	public OfferPage offerPage;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getofferPage();
	}
	
	public void switchToOffersPage() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		
//		landingPage landingPage = new landingPage(testContextSetup.driver);
		landingPage.selectTopDealsPage();
		 testContextSetup.genericUtils.switchWindowToChild();
	}
	
	@Then("User searched with {string} shortname in offers page")
	public void user_searched_with_the_same_shortname_in_offers_page_and_validate_if_product_is_exist(String shortName) throws InterruptedException {
		 
		 switchToOffersPage();
//		 offerPage offerPage = new offerPage(testContextSetup.driver);

		 offerPage.searchItem(shortName);
		 Thread.sleep(2000);
		 
		 offerPageProductName = offerPage.getProductName();
		 System.out.println(offerPageProductName + " is extracted from offerPage");
	}
	
	//for scenario outline
	//delete this
	@Then("User searched with {string} shortname in offers page outline")
	public void user_searched_with_shortname_in_offers_page_outline(String name) throws InterruptedException {
		 switchToOffersPage();
//		 offerPage offerPage = new offerPage(testContextSetup.driver);
		 offerPage.searchItem(name);
		 Thread.sleep(2000);
		 
		 offerPageProductName = offerPage.getProductName();
		 System.out.println(offerPageProductName + " is extracted from offerPage");
	}
	
	@Then("validate if product is exist with same name")
	public void validate_if_product_is_exist_with_same_name() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
		System.out.println(testContextSetup.landingPageProductName + " from landingPage is the same with " + offerPageProductName + " from offerPage");
		
	}
	
//	@After
//	public void tearDown() {
//		driver.close();
//	}
	
}
