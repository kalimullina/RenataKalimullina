Feature: Checking the work of different elements on the Different Elements Page

  Scenario: Select checkboxes radio, dropdown and check log rows
    Given I open JDI GitHub site
    And I login as "Roman" with "Jdi1234" password
    When Open through the header menu Service -> Different Elements Page
    And I select Water and Wind checkboxes
    And I select Selen radio
    And I select Yellow in dropdown
    Then Check for each selected element individual log row
