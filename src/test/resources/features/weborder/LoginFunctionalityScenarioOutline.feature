Feature: Testing all negative login functionality with Scenario outline

  Scenario Outline: negative login w. correct username but wrong password
    When User enters the username '<username>' and password '<password>' and clicks login button
    Then User validates the message '<message>'
    Examples:
      | username              | password      | message        |
      | 123@gmail.com         | Guest1!       | Sign in Failed |
      | guest1@microworks.com | wrongPassword | Sign in Failed |
      |                       |               | Sign in Failed |

