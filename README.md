# Cucumber
Cucumber is a Behavior-Driven Development (BDD) testing tool that uses the Gherkin language to describe software behavior in a human-readable format. Gherkin follows the Given-When-Then structure and allows collaboration between technical and non-technical stakeholders. Cucumber automates these scenarios using step definitions in programming languages, ensuring that the software aligns with specified behavior.

Tech Stack Used for this Mobile Automation:
- IDE: Eclipse
- Framework: Cucumber, Selenium, TestNG
- Language: Java
- CI/CD Tools: Jenkins

## Initial Setup
1. Install Java
2. Set JAVA_HOME Path in Environment Variable
3. Install Eclipse
4. Install "Cucumber Eclipse Plugin" Extention on Eclipse (Open Help -> Eclipse Marketplace -> Search Cucumber -> Install)

## Pre-Automation
1. Create Maven Project
2. In pom.xml add "Cucumber JVM: Java" and "Cucumber JVM: TestNG" Dependencies
3. Under src/test/java create package -> features (to put all the feature you want to test)
4. Under src/test/java create package -> cucumberOptions (to put the TestNGRunner)
5. Under src/test/java create package -> stepDefinitions (to put all the step for every feature)
6. Inside cucumberOptions package, create TestNGRunner.java file
7. Inside the class add @CucumberOptions annotation, and then extends the "AbstractTestNGCucumberTests" in your main class
8. Inside features package, create .feature file that contains the Feature,Scenario,and Steps(Given,When,Then,And)
9. Inside stepDefinitions package, create .java file that contains sets of actions related to the defined Steps in .feature file

## Start your Automation
1. Inside the .feature file (for example searchProduct.feature) create a:
   - Feature: 
