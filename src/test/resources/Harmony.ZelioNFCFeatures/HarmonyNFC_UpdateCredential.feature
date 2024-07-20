Feature: Update Credentials under M262 PLC

  @Update_Credentials @Device_Android @Author_SESA698287
  Scenario Outline: Launch the Industrial Mobile Device and update the credentials under M262 PLC
    Given Launch the Application and do accept and agree
    When Click on plus button under home screen of Industrial Device
    Then Click on Select product option on the connection popup
    Then Click On PLC
    And Click On M262
    And Click On TM262M25MESS8T
    Then Enter Valid "<ipAddress>" IPAddress
    And Enter Valid "<username>" Username and "<password>" Password
    Then Click On CONNECT button
    Then Verify User is Logged-in successfully!

    Examples:
      | ipAddress  | username | password |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |
      |127.20.23.21|   admin  |  admin   |


