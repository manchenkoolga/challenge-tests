Feature: Challenges List

  Background: Operator Logs In
    Given I navigate to the Home Page
    When I enter "15sofAdmin" valid credentials
    And I click on SignIn button

   Scenario Outline: Resolve Users Reports
     Given I navigate to "content-moderation" section
     When I click on "reported-users" tab
     And I click on "new-reports-reported-users" tab
     And I select random user report
     And I "<setReportResolution>" random user report
     Then I should No longer see my random user report in the list
     Examples:
       | setReportResolution |
       |  confirm            |
       |  cancel             |





