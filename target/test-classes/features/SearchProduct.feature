Feature: Search and Buy Product

@SearchProduct
Scenario: Search Experience for product search in home and offers page

Given User is on GreenCart landing page
When User searched with shortname "tom" and extract the actual name of the product
Then User searched with "tom" shortname in offers page 
And validate if product is exist with same name


