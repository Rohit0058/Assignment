 Exercise - 2 -> E2E Working Test Case for the Purchase Flow.
 Please Clone this Repo, open it in Android Studio, do Gradle Build and Execute the PurchaseFlowTest.kt
 
 Structure -> 
--- androidTest
  
  -- pageObjects
    - CartPage.kt
    - CheckoutPage.kt
    - LoginPage.kt
    - ShowcasePage.kt
    - ItemDetailsPage.kt
  
  --tests
    - PurchaseFlowTest.kt
  
  --utils
    - TestConstants.kt
    - TestUtils.kt
    - TestLogger.kt
   
  Scenario 1 -> Please Refer to PurchaseFlowTest.kt along by referring the above Structure 

  /* Scenario 2.1 - Checking Screen while Transition and Handling Slow Network
  Polling for Visibility:
  The assertScreenIsDisplayed function checks if the screen is visible and uses waitUntil to poll until
  the node is found and visible. This way, the test only moves on when the UI is ready,
  avoiding arbitrary waits.
  No Hardcoded Delays:
  This implementation does not rely on hardcoded wait times but instead checks the actual UI state,
  making it more reliable and efficient.
  ***** Refer to File TestUtils.kt ******
   */ 

  /* Scenario 2.2 -
   "before steps" refer to actions that are executed before the main test logic runs.
   They are crucial for establishing a consistent state and preparing the environment for the test.
   Before steps are a foundational part of a well-structured testing strategy,
   ensuring that tests are reliable, maintainable,and easy to understand.
   They help ensure that the conditions are right for your tests to run accurately
   and provide meaningful results.
   ***** Refer to File PurchaseFlowTest.kt ******
   */
     
  /* Scenario 2.3 -> For the bonus point regarding asserting the number of items in the cart:
  
  Real-time Assertion: It's crucial to keep track of the number of items in the cart in real-time
  for a more dynamic user experience.
  As users add or remove items, the count should be updated and asserted against expected
  values during the testing process.
  
  Flexibility: Instead of hardcoding expected values, implementing logic to assert the actual count
  of items allows for more robust testing. This dynamic approach can help identify issues
  related to item management in the cart.
  ***** Refer to File TestUtils.kt ******
   */
