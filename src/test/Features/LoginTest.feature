Feature: Test Prime App

  Scenario Outline: Play a video in Amazon Prime
    Given user opened the Prime Appication and on login Screen
    Then User login to the application using "<UserName>"
    Then User navigate to Search Screen
    When User enter the Movie Name in the search box "Acharya"
    And click on Enter Button
    Then User should be displayed with the Movie Name
    When User select the movie
    Then User should be displayed with Movie Information Page
    When User click on Watch Now or Continue Watching
    Then the movie should start playing

    Examples:
      | UserName   |
      | 9569992716 |