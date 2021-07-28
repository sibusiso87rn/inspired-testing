# Web and Services Automation Framework

## Prerequisites

1.Java 8+

## Tech Stack

* RestAssured for Services
* Cucumber for test case specifications
* Selenium for web test cases
* Maven as a build tool

## Running The Tests

* All testNG files can be located on the tests/resources/testng
* For web run src/test/resources/TestNG.xml
* For services run src/test/resources/TestNG.xml
* Alternatively you can run the mvn test on the parent folder, all tests will runn 
 
### Web Framework

* You can specify if you want a specific driver and or specific browser on the testng file
* The framework will download and run it
* NOTE: The driver might take time to download if its being used for the first time.

##Reports

Once the test suit has finished executing the following reports are generated under the target folder

* Cucumber Report on this directory target/cucumber-html-reports and open -> (overview-features.html)
* Extent Report on this directory target/test-output/HtmlReport and open -> (ExtentHtml.html)

## High-level Framework Overview

The framework uses Cucumber to describe high-level functional tests. 

* Page Actions are used to perform user actions and validate expected results.
* Page Objects are used to store all element objects for each screen.

## Web Elements Naming Standards 

| WebElement Type  | Prefix | Examples                 |
|------------------|--------|--------------------------|
| Text Box         | txt    | txtEmail , txtPassword   |
| Button           | btn    | btnRegister , btnLogin   |
| Drop down        | dd     | ddCountry , ddYear       |
| Select Drop Down | sdd    | sddMonth , sddYear       |
| Check Box        | cb     | cbGender, cbSalaryRange  |
| Header           | hdr    | hdrPrint, hdrUser        |
| Table            | tbl    | tblBooks, tblProducts    |
| Label            | lbl    | lblUserName, lblPassword |
| Image            | lbl    | imgProfile, imgCart      |
| Video            | vdo    | vdoWelcome               |

## User Actions Naming Standards
| Action                      | Prefix | Examples                |
|-----------------------------|--------|-------------------------|
| Check a check box           | chk    | chkGender               |
| Click                       | clk    | clkSigin, clkRegister   |
| Select value from drop down | select | selectYear, selectMonth |
| Type                        | set    | setEmail, setPassword   |

## Gherking and BDD
The Golden Gherkin Rule: Treat other readers as you would want to be treated. Write Gherkin so that people who don’t know the feature will understand it.

The Cardinal Rule of BDD: One Scenario, One Behavior!

Write all steps in third-person point of view. If first-person and third-person steps mix, scenarios become confusing.

* Givens should always use present or present perfect tense

* Whens and Thens should always use present tense.

## References

* https://automationpanda.com/2017/01/30/bdd-101-writing-good-gherkin/

## Credits

Sibusiso Radebe

## License
