Feature: automationPractice


  @SearchItem @Assignment

  Scenario Outline:  User are able to search for an item using the search bar



    Given I navigate to homepage "http://automationpractice.com/index.php"

    Then I click on searchbar and search "<Item>"

    And I validate that the results returned matches the search "<Item>"



    Examples:

      | Item                        |

      | Faded Short Sleeve T-shirts |

      | Printed Chiffon Dress       |

      | Blouse                      |


  @WomenCategory @Assignment

  Scenario Outline: User are able to filter search results under Women category by Color and Category



    Given I navigate to homepage "http://automationpractice.com/index.php"

    Then I click on "Women" category

    Then I select any value from the "<Color>" and "<Category>" filter item

    And I validate that the results returned matches the filter criteria with "<Color>" and "<Category>"

    Examples:

      | Color | Category |

      | Black | Tops     |

      | Blue  | Dresses  |


  @Popular @Assignment

  Scenario Outline: Users are able to view the details of any clothing item from the POPULAR section and add them to cart



    Given I navigate to homepage "http://automationpractice.com/index.php"

    Then I select any "<Item>" from the "Popular" section and add them to cart

    And I validate that the "<Item>" has successfully been added to the cart



    Examples:

      | Item                        |

      | Faded Short Sleeve T-shirts |