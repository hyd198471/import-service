Feature: In order to maintain a picture of a matchstate
  As a service
  I want to submit an updated match details to ebet when Betgenius sends us an update

  @FirstScenario
  Scenario: Receiving Football Match 1
    Given Football game match-1
    And eBet replies by default with code 202
    When BetGenius sends a create-event message
    Then 1 messages are written to MessageLog
    And eBet should have received a create-event message
    When BetGenius sends a create-markets message
    Then 2 messages are written to MessageLog
    And eBet should have received a update-with-bet-markets message
    When BetGenius sends a start-1-half message
    Then 3 messages are written to MessageLog
    And eBet should have received a update-with-start-1-half message
    When BetGenius sends a goal message
    Then 4 messages are written to MessageLog
    And eBet should have received a update-with-goal message
    When BetGenius send a end-1-half message
    Then 5 messages are written to MessageLog
    And ebet should have received a update-with-end-1-half message
    And 0 poison messages are stored in poison audit log
    Then eBet should have received no more message


  @LastScenario