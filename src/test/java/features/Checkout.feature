Feature: Search and Buy Product

@CheckoutScenario
Scenario Outline: Add product to cart and checkout the product

Given User is on GreenCart landing page
When User searched with shortname <Name> and extract the actual name of the product assignment
And User add <Quantity> items of the selected product to the cart
Then User checkout the product and validate the <Name> and quantity of the product in checkout page
And Verify if user has ability to enter <Code> promo code and place the order 

Examples:
|Name|  |Quantity| |Code|
|Tom|   |3|        |Test|
|Cap|   |55|       |123|
|Bro|   |111|      |ABC|