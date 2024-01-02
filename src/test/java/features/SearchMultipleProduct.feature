Feature: Search and Buy Product

@SearchMultipleProduct
Scenario Outline: Search Experience for product search in home and offers page

Given User is on GreenCart landing page
When User searched with shortname <Name> and extract the actual name of the product outline
Then User searched with "<Name>" shortname in offers page outline
And validate if product is exist with same name

Examples:
|Name|
|Car|
|Cucu|
|Pot|