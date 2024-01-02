package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	    this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^Verify if user has ability to enter (.+) promo code and place the order$")
	public void verify_if_user_has_ability_to_enter_test_promo_code_and_place_the_order(String promoCode) throws InterruptedException {
	    checkoutPage.usePromoCode(promoCode);
	    checkoutPage.placeOrder();
	    Thread.sleep(500);
	}
}
