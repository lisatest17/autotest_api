#language: en
Feature: Testing methods from the module store

  @smoke
  @regress
  Scenario: Create order
    When create order status code 200
      | id       | 0                        |
      | petID    | 0                        |
      | quantity | 0                        |
      | shipDate | 2023-09-02T11:30:00.828Z |
      | complete | true                     |
      | status   | placed                   |

  @smoke
  @regress
  Scenario: Create order
    When create order status code 200
      | id       | 0                        |
      | petID    | 0                        |
      | quantity | 0                        |
      | shipDate | 2023-09-02T11:30:00.828Z |
      | complete | true                     |
      | status   | placed                   |
    And get the order status 200
    Then delete the order status 200
