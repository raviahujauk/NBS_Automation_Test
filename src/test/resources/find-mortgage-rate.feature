Feature: Find a mortgage rate
  As a new customer
  I want to find the mortgage rates available
  So that I can decide whether to switch my mortgage to Nationwide

  @Pending
  Scenario Outline: Find mortgage rates
    Given I open the url "https://www.nationwide.co.uk"
    When I mouse hover on menue "Motgages"
    And I click "Mortgage rates" from sub menu New mortgage customer
    And I click "<Nationwide_Mortgage>" option
    And I click mortgage type "<Mortgage_type>" option
    And I enter "<Property_value>" amount
    And I enter Mortgage amount "<Mortgage_amount>"
    And I enter Term value "<Term>"
    And I click find a mortgage rate button
    And I select mortgage type filter "<Mortgage_type_filter>"
    And I select product fee filter "<Product_fee_filter>"
    Then I verify result returns following products
      | 2 yr Fixed  |
      | 3 yr Fixed  |
      | 5 yr Fixed  |
      | 10 yr Fixed |
    And I click "More Info and apply" link
    And I click "Apply" button for the "5 yr Fixed" product
    And I verify next page heading "Start your remortgage application"
    Examples:
    | Nationwide_Mortgage | Mortgage_type       | Property_value | Mortgage_amount | Term | Mortgage_type_filter | Product_fee_filter |
    |        No           | I'm changing lender |   300000       |  150000         |  30  |  Fixed               |  With Fee          |