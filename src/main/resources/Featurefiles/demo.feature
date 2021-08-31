

Feature: rediect to url

  @testcase1
  Scenario: Open URL
    Given I have a url
    When I get the url
    Then it should rediect and open the URL on browser


@testcase2 
Scenario: Login
Given I navigate to login page 
When I put <Email> and <Password>
| kansariakartik126@gmail.com | Kartik@123 |
And I click on Login
Then I should be on Dashboard page

@testcase3
Scenario: Sign up
Given I navigate to Sign up
When I put <First Name> , <Last Name> , <Phone>, < Email1> and <Password1>
| kartik | Kansaria | 9028212311 | kansariakartik126@gmail.com | Kartik@123 |
And I click on Sign up button
Then I should be on Login Page with the expected title

@testcase4
Scenario: Hotel booking
Given I navigate to hotel page 
When I put city name 
And I select Check in date 
And I select Check out date
And select travellers with Rooms, Adults and Child
And select Nationality
And I click on search hotel
Then I should be on list of hotels page. 

@testcase5
Scenario: Flight Booking
Given I navigate to Flight page
When I put Round Trip
And I select Flying From 
And I select To Destination
And select Departure Date
And select Return Date
And select Passengers
And I click on search flight
Then I should get the list of flights

@testcase6
Scenario: Selection of Flight 
Given I select Flight 
When I add traveller information <First name> and  <last name> 
| Kartik | Kansaria |
| vipul | hodge |
| vatsal | patel |
And I select the nationality 
And I select the date of birth for month , <date> and <year>
| 21 | 1996 |
| 23 | 1995 |
| 20 | 1990 |
And I select the <passport number>
| 1231313 |
| ABC1309 |
| KJDKJD981 |
And I select expiry date the month, <date> and <year>
| 15 | 2025 |
| 22 | 2045 |
| 21 | 2024 |

@testcase7
Scenario: Selection of Tour
Given I navigte to Tour page
When I select City
And I select date
And I select the number of travellers
And I click on search Tour
Then I should get list of tours

@testcase8
Scenario: Details of Tour
Given I select one tour
When I add date 
And I select number of adults
And I select number of child 
And I book now 
Then I should be redirected to Traveller information 

@testcase9
Scenario: Traveller information 
Given I navigate to traveller information for tours 
When I add Traveller information <First name> and <last name> 
| Kartik | Kansaria | 
| Vipul | Hodge |
| Dhruvil | Vachetta | 
And add payment method
And I confirm the booking 
Then I should get the confirmation

@testcase10
Scenario: Cars 
Given I navigate to car page
When I select Return 
And I select origin
And I select Destination
And I select From Date 
And I select End Date 
And I select traveller
And I click on search cars
Then I should be able to get the cars

@testcase11
Scenario: Dashboard 
Given I navigate to dashboard page 
When I select mybookings
And add funds
And I click on myprofile
And I Click on logout 
Then I should be back on home page 















