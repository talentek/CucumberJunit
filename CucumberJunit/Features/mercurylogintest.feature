Feature: Login Test For Mercury

  Scenario Outline: Successful login into the Mercury Tours user account with valid credential
    Given User on Mercury Tours home page
    When User entered valid "<username>" and "<password>"
    Then Flight reservation page should open

    Examples: 
      | username | password |
      | guest    | guest    |
      | talentek | pass     |
