# bitpanda-tasks-solution

## Technological stack and project structure

Project was created as multi module maven project

Each module corresponds to each specific task

### UI-TASK MODULE

In this module are placed ui-tests that uses this stack:

- Selenide
- Allure
- Assertj
- TestNG
- Faker

System under test link -> [here](http://automationpractice.com/index.php)

### API-TASK MODULE

In this module are placed api-tests that uses this stack:

- Restassured
- Allure
- Assertj
- TestNG

Also postman collection can be found in src/main/resources/postman path

System under test link -> [here](https://uebermaps.com/)

### LOAD-TASK MODULE

In this module are placed load-tests that uses this stack:

- Junit5/4
- Allure
- Zerocode

Also Jmeter jmx file can be found in src/test/resources/jmeter path

System under test link -> [here](https://orangehrm-demo-6x.orangehrmlive.com/auth/login)

## Project CI/CD

This Project's CI/CD is made with Github Actions

## How to run this project

- You can either fork this project and run your Github Actions or create pull request to trigger actions here
- You can pull project and run it locally with command "mvn clean test", however you need to provide specific variables

### Test Args/Variables
- API_USER - user for api tests to authenticate
- API_PASSWORD - password to authenticate to API to acquire token
- isHEADLESS - to set UI tests in headless or no-headless mode

## How to get report from test runs

All the tests use Allure Framework as reporting tool. In order to generate report with it, one must first download and setup allure commandline.
Information to how setup this commandline can be found on Allure's official documentation [here](https://docs.qameta.io/allure/) 
in section **Installing a commandline** under *2.1.4. Manual installation*.

Once it is setup up, one does need to be in project directory and run command

```shell script
$ allure serve [results_location]
```
for example

```shell script
$ allure serve ui-task/target/allure-results
```

_All results are placed in target folder in each module_
