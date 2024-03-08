#language: en
  Feature: Number TK

    @smoke
    @regress
    Scenario: Post pet
      When post pet with parametrs that 200

      | id | 0 |
      | category.id | 0 |
      | category.name| string|
      | name | doggie |
      | photoUrls | string |
      | tags.id | 0 |
      | tags.name | string |
      | status | available |
      And get pet that 200
      Then delete pet that 200