Feature: Challenges List

  Background: Operator Logs In
    Given I navigate to the Home Page
    When I enter "15sofAdmin" valid credentials
    And I click on SignIn button

    Scenario Outline: Check Challenge Status by Tabs
      When I navigate to "challenges" section
      And I click on tab "<tabTitle>"
      Then I verify that challenges on this tab have  "<challengeStatus>" status

      Examples:
      | tabTitle | challengeStatus |
      | draft    | draft           |
#      | ended    | ended           |
#  TODO: need to pass TabName/Challenge status to rows so we can easily find ended/draft/acitve challnege rows "//tr[@data-row-key]"


