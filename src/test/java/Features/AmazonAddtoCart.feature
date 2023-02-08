@Task
Feature: AmazonAddtoCart

  Scenario: User Add Item to Cart from Search
    Given Open Amazon Website
    When User Add Item To Cart
    Then Item Is Added Successfully
    When Filter The Products in Todays Deals
    Then Add item from Deals to Cart