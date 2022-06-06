Feature:  

Scenario: Verifying securepay through google
Given User is on "https://www.google.com/" page
When enter "securepay" in google tab  
And press enter 
And click website 
Then validate url "https://www.securepay.com.au/" 
When select pricing and click standard pricing
Then verifying page load and "https://www.securepay.com.au/pricing"
When scrolldown to click LearnMore
Then checking the payment window is loaded and "https://www.polipayments.com/"
When clicking contact us & get started 
Then Signupage must be loaded & verifying "https://signup.apac.paywithpoli.com/"
When Navigate to sell and make a sales enquiry & verifying the sales "https://www.polipayments.com/#salesform"
And Close browsers


