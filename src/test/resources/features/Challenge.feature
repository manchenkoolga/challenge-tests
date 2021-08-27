
Feature: Create New Challenge

  Background: Operator Logs In
    Given I navigate to the Home Page
    When I enter "15sofAdmin" valid credentials
    And I click on SignIn button
    Then I should see Idea Submission Banner Section

  Scenario: Operator Creates New Challenge with valid parameters
    When I navigate to "challenges" section
    Then I should see Create Challenge Section
    When I click on Create New Challenge button
    Then I should see Creating New Challenge page
    When I enter Challenge Title
    And I select Challenge Interest
    And I enter Challenge Hashtag
    And I enter Challenge Description
    And I enter Challenge Start Date
    And I enter Challenge Start Time
    And I enter Challenge End Date
    And I enter Challenge End Time
#    And I upload Challenge Image "challengeCover.png"
    And I click on Save Draft button
    Then I should see Challenge Details screen

  Scenario: Operator Edits a Challenge
    When I navigate to "challenges" section
    And I select a random challenge
    And I click on Edit challenge button
    Then I should see Edit Challenge screen
    When I clear Challenge Title input field
    And I enter Updated Challenge Title
    And I click on Save Draft button
    Then I verify Challenge Title "was updated"

  Scenario: Operator Ends Promotion
    When I navigate to "promote-challenges" section
    And I select random promoted challenge
    And I end Promotion for random challenge
    Then I verify promoted challenges list does not contain my random challenge

  Scenario: Operator Activates/Edits/Deactivates Idea Submission Banner
    Given I deactivate Idea Submission banner via API

    # Activate Idea Submission Banner
    When I change Idea Submission Banner Status
    And  I should see Submission Banner "is" active
    Then I should see Submission Banner details are visible
    And I should see Save button is disabled
    When I enter "1" as a reward in reward input field
    And I Enter Submission Start Date
    And I Enter Submission End Date
    And I Enter Submission Start Time
    And I Enter Submission End Time
    And I click on Save button on Idea Submission Banner status page
    Then I should see Edit button is displayed on Idea Submission Banner status page

    # Edit Idea Submission Terms
    When I click on Edit button on Idea Submission Banner status page
    And I select random value for Idea Reward
    And I update Idea Reward in reward input field
    And I update Submission Start Date
    And I update Submission End Date
    And I update Submission Start Time
    And I update Submission End Time
    And I click on Save button on Idea Submission Banner status page
    Then I should see Idea Reward is updated
    And I should see Submission Start Date is updated
    And I should see Submission End Date is updated
    And I should see Submission Start Time is updated
    And I should see Submission End Time is updated

    #Deacrtivate Idea Submission Banner
    When I change Idea Submission Banner Status
    Then I should see Save button is disabled
    And  I should see Submission Banner "is not" active






