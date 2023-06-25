#1-Login successfully weborder page parameterize username and password in feature file
  #2 click the order box and next button
  #3 send invitees section to "I LOVE SELENIUM"
  #4 send inviteList "email@gmail.com" and "email2@gmail.com"
  #5 choose the delivery option "My House" and validate adress(contains) "3137 Laguna"
  #6 click group order button
  #7 Validate the header "View Group Order"(think about thread.sleep)
  #8 Validate the description contains(Your group order is now pending) from description

Feature:  Testing food order functionality
 Background: Food Order same steps
  Given User enters the correct username 'guest1@microworks.com' and password 'Guest1!' and clicks login button
  When User checks the group order box and clicks next button
 #if both scenarios repeating steps within the same feature, Background comes handy
 #it'll run before every scenario
 #BUT!!! IT STOPS AT THE STEP WHEN IT'S NOT REPEATING; even the ones after the "non-repeated" are repeating,
 #those don't count


Scenario: testing HappyPath for MyHouse Food Order
# Given User enters the correct username 'guest1@microworks.com' and password 'Guest1!' and clicks login button
# When User checks the group order box and clicks next button
  And User sends 'I LOVE SELENIUM' message at invitees section and add 'email@gmail.com' and 'email2@gmail.com' to the inviteeList
  #or we can split the 2 emails part under another And. the , can be outside in between the two parameters
  Then User chooses the delivery option my house and validates the address contains '3137 Laguna'
  Then User clicks group order button and validates the header 'View Group Order' and description contains 'Your group order is now pending'


 Scenario: testing HappyPath for Office Food Order
#  Given User enters the correct username 'guest1@microworks.com' and password 'Guest1!' and clicks login button
#  When User checks the group order box and clicks next button
  And User sends 'I LOVE Cucumber' message at invitees section
 And add 'email3@gmail.com' and 'email4@gmail.com' to the inviteeList
  Then User chooses the delivery option 'Office' and validates the address contains '2012 EMPIRE'
  Then User clicks group order button and validates the header 'View Group Order' and description contains 'Your group order is now pending'