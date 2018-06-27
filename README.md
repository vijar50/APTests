# APTests
automationpractice.com 

To use this code you will need the following:
- Selenium
- ChromeDriver 
- TestNG (set up through Eclipse for Annotations and Assertion mainly)

Selenium Files are located in src/resources and src/testCases

Below is a description of each file:

src/resources/builderClass.java

This file is where the Webdriver object is defined and the browser specified. 
Please note the path of chromedriver is set to a path on my local machine. This will have to be updated
to wherever you have your chromedriver.exe located

src/testCases/PositiveTest.java

This file contains 3 different tests. Before each test there is a setup and tear down function run 
using the driver object. You can read about what the test does in the comments of the file. 
All tests should pass.

src/testCases/NegativeTest.java

This file contains 2 different tests. Before each test there is a setup and tear down function run 
using the driver object. You can read about what the test does in the comments of the file. One test
should fail, the other will pass.

NOTE: No logging has been added to these tests.
