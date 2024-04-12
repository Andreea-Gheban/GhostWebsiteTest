# 1.Introduction

This is a quick guide on how to set up and running this Java-Selenium framework.
The framework is build to test the Front End of https://ghost.org web application. 
The tests contain feature tests;

### A few particularities in short:

- the framework is build in ```Java``` with ```JUnit```, ```Maven``` and ```Cucumber```;
- the tests are written with the ```Gherkin``` syntax;
- the  framework uses the ```POM (Page Object Model``` design pattern, so each page element is stored in a class, then
  steps methods are stored in other classes, and the ```Gherkin``` steps are written in ```.feature``` files;
- the tests run in the ```Chrome browser```

________________________________________________________
# 2.Setup and run first test

Below all the required steps to set up the framework.

### 1. Setup - instructions for Windows 10
1.First, Install JAVA JDK installed - [Download link](https://www.java.com/en/download/);

2.Set JAVA_HOME in System Variables - try this
[Web tutorial](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html);

3.Install Intellij Java IDE -
[Download link](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC);

4.Install Git for Windows - [Download link](https://gitforwindows.org/), open it and Login with your account.

5.Make a new folder in your desired location to clone the project there. Once in the folder, right click in the folder
and open the GIT Bash. Insert the following command:


``` git clone https://github.com/Andreea-Gheban/GhostWebsiteTest.git ```

This command will clone the GHOST PROJECT locally

### 2. Install framework dependencies


This framework uses Cucumber and Gherkin as main dependencies.

After the project is cloned, right click it and open it in Intellij Java IDE and follow the steps:

1. When first opened, Intellij will prompt you to install two Plugins, ```Cucumber``` and
   ```Gherkin```;
    - install them from the popup or from the Plugins Editor in Settings;
    -  Restart Intellij after it;


2.  After restart, Intellij might prompt you to set up the ```SDK``` to use (what java version should Intellij use for the
    framework).
    For this framework, I went with ```JAVA SDK 21```.

    This can be setup by ```right-clicking
    the project folder > Open Module Settings > SDK tab```; and from there you can download ```SDK Corretto-21``` 

    * Restart Intellij after the SDK is downloaded;


### 3. Run first test.
After all the above steps are completed, you should be fine to go.
We can now RUN our first test.
There are more ways to do this but for start you can do it this way:

1. Go to ``` src/test/java/TestRunner.java ```
2. In this ```TestRunner.java ``` file, edit and replace the ```@all``` tag with ```@price``` tag (this tells the framework to only execute the
   Test for the Login functionality--in this way we only execute just a few quick tests to see that setup was done ok)

3. Click to green button near the ```public class TestRunner```
4. The tests should start executing in the RUN console
  
________________________________________________________
# 3.Framework use


### Project folder structure

    
        - src     
            - main:
                - java:
                    - common // here classes used thoughout 
                                all framework are kept like BaseClass for WebDriver initialize, Price and Resources for locators and pages general methods;
                   
                - resources
            - test:
                - features  // here all the Cucumber tests are stored in specific feature 
                                   files that has the name of the coresponding Ghost website page;
                - java
                    - steps // here the Cucumber steps are implemented;
                    - hooks  // hooks class where it is defined with JUnit annotations 
                                the actions done @Before and @After a test is executed;
                    
                   
                    - TestRunner.java // runner class to execute the Cucumber tests with any needed
                                         annotations like @regresion, @price, @resources or other adnotation that may be defined in the future;
                
                    
                
        - target   -- test artifacts are save here like html reports;
        - pom.xml  -- project config file with all used dependcies;
        - readme.md
        

## Framework use - flow for implementing a new Test Case


1. Add the Cucumber test in the corresponding .feature file for the page you want to test or create a new .feature
   file if needed. Add the test there in this format:
   ```Gherkin
Feature: Resources Page

  Scenario: Check if complete guide for new blog opens
    Given The user navigate to the ghost page                //GIVEN = preconditions of the test
    When The user click on "Resources" menu                  //WHEN  = actions or steps to execute the test
    And The user click on Start here section                 //AND   = connection keyword to add any more preconditions, actions or verifications;
    Then The can see that page with guides opens             //THEN = assertion/verification 
    When The user search for "create new blog"
    Then The user open the tenth result
    Then The user can check that content is loaded

   ```

   When first added, the tests will be highlighted because there are no corresponding implementations for them yet;


2. Add the new elements in the ```/common``` folder, in the corresponding page;
    - here use the  ```public static final By name_of_element;``` with By``` annotation to add any ```ID``` or ```XPATH``` element
     
3. After elements are added, we can start implementing the ```Cucumber``` steps.
   From the ```.feature``` file, copy the step that needs to be implemented and go to the ```steps``` directory in the folder
   that contains the required page of functionality to test;

   In the Steps class, add a new method in this format:
    ```java
   @Then("insert here the name of the Cucumber test to implement")
   public void nameOfTheCucumberStep(){
        //insert here Selenium actions 
        }
    ```
   To check that a Cucumber step was implemented ok, after the step definition for this step is done, head over to the
   ```feature``` file again and check that the Step is no longer highlighted, and the user can teach the
   defined step by using ```CTRL+click```;

4. After all the Cucumber steps are implemented, the test can be executed and committed;


## Framework use - ```Cucumber``` tags

- this framework uses Cucumber as a framework for BDD testcases writing;
- Cucumber has the possibility to add tags to any test or feature file in this format ```@test``` or ```@example```;
- the tags can be added at the top of the feature file or before each scenario;
- when a ```@tag``` is added in the testRunner, all testes with the ```@tag``` used are executed;  
  &nbsp;

  Example for the use: first, add the ```@exampleTag``` for this test:
     ```Gherkin
      @exampleTag
       Scenario: Check if complete guide for new blog opens
    Given The user navigate to the ghost page              
    When The user click on "Resources" menu                
    And The user click on Start here section               
    Then The can see that page with guides opens             
    When The user search for "create new blog"
    And The user open the tenth result
    Then The user can check that content is loaded
   ```
  Then, in the ```TestRunner``` or in the ```config.yml```, use the ```@exampleTag``` in the tags section:
    ```java
        @RunWith(Cucumber.class)
        @CucumberOptions(
            plugin = {"pretty","html:target/html_report/latest_run.html", "rerun:target/failed_scenarios.txt"},
            features = "C:\\Users\\Admin\\IdeaProjects\\ghost\\src\\test\\features",
            glue = {"steps"},
            tags = "@exampleTag")
    ```

##
  

