Feature: Get price in action of a brand and a product at a specific date and time

  Scenario: Test 1 - Request at 10:00 on 14th June for product 35455 and brand 1 (ZARA)
    Given the brand is "1"
    And the product id is "35455"
    And the date and time is "2020-06-14T10:00:00Z"
    When I check the price
    Then I should get a price record:
      | product_id | brand_id | price_list | start_date            | end_date              | price |
      | 35455      | 1        | 1          | 2020-06-14T00:00:00Z  | 2020-12-31T23:59:59Z  | 35.50 |

  Scenario: Test 2 - Request at 16:00 on 14th June for product 35455 and brand 1 (ZARA)
    Given the brand is "1"
    And the product id is "35455"
    And the date and time is "2020-06-14T16:00:00Z"
    When I check the price
    Then I should get a price record:
      | product_id | brand_id | price_list | start_date            | end_date              | price |
      | 35455      | 1        | 2          | 2020-06-14T15:00:00Z  | 2020-06-14T18:30:00Z  | 25.45 |

  Scenario: Test 3 - Request at 21:00 on 14th June for product 35455 and brand 1 (ZARA)
    Given the brand is "1"
    And the product id is "35455"
    And the date and time is "2020-06-14T21:00:00Z"
    When I check the price
    Then I should get a price record:
      | product_id | brand_id | price_list | start_date            | end_date              | price |
      | 35455      | 1        | 1          | 2020-06-14T00:00:00Z  | 2020-12-31T23:59:59Z  | 35.50 |

  Scenario: Test 4 - Request at 10:00 on 15th June for product 35455 and brand 1 (ZARA)
    Given the brand is "1"
    And the product id is "35455"
    And the date and time is "2020-06-15T10:00:00Z"
    When I check the price
    Then I should get a price record:
      | product_id | brand_id | price_list | start_date            | end_date              | price |
      | 35455      | 1        | 3          | 2020-06-15T00:00:00Z  | 2020-06-15T11:00:00Z  | 30.50 |

  Scenario: Test 5 - Request at 21:00 on 16th June for product 35455 and brand 1 (ZARA)
    Given the brand is "1"
    And the product id is "35455"
    And the date and time is "2020-06-16T21:00:00Z"
    When I check the price
    Then I should get a price record:
      | product_id | brand_id | price_list | start_date            | end_date              | price |
      | 35455      | 1        | 4          | 2020-06-15T16:00:00Z  | 2020-12-31T23:59:59Z  | 38.95 |

