sunshine
========

[![Build Status](https://travis-ci.org/tatools/sunshine.svg?branch=master)](https://travis-ci.org/tatools/sunshine)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![Rultor.com](http://www.rultor.com/b/tatools/sunshine)](http://www.rultor.com/p/tatools/sunshine)

@todo #18:15m Add maven central badge here.

What is Sunshine?
=================
**Sunshine** is a wrapper on xUnit test runners (such as TestNG, Junit...) which allows automatically
[find classes with tests](#filter-tests-to-be-run) within the jar file, passes them to desired test runner and reports
an execution status.

How does Sunshine work?
=======================
Once you have configured Sunshine for your project, you are able to build `my-automated-tests.jar`
file with your automated tests.
Next time, when you will run automated tests with `java -jar my-automated-tests.jar`, Sunshine will
1. scan all classes within your JAR
2. filter classes by [provided pattern](#filter-tests-to-be-run)
3. run found tests using defined test runner
4. report run statistic and exit code of the test runner

Sample output:
```bash
$ java -jar sunshine-testng-integration-tests-unspecified.jar
The following pattern will be used for classes filtering: (.+)([Tt]est)([\w\d]+)?
Sunshine found 3 classes by the specified pattern. They all will be passed to appropriate xUnit engine.
Classes:
- io.github.tatools.testngtests.PassedTest
- io.github.tatools.testngtests.TestNGXmlTest1
- io.github.tatools.testngtests.TestNGXmlTest2

===============================================
Sunshine suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================
```

Supported Java tests runners
============================
- [TestNG](http://testng.org) - tested on `6.11`
- [JUnit4](http://junit.org/junit4) - tested on `4.11`

How to start using?
===================
1. Make sure you have the following project structure:
    ```
    src/main   <- your code here, including automated tests
    src/test   <- your unit tests here
    ```
2. Add Sunshine dependency based on your tests runner:
    - use `sunshine-testng` for TestNG
    - use `sunshine-junit4` for Junit4
3. Configure main class for your JAR:
    - use `io.github.tatools.sunshine.testng.Sunshine` for TestNG
    - use `io.github.tatools.sunshine.junit4.Sunshine` for JUnit4
    - or create your own configuration
4. Build JAR file with `mvn clean build` or `gradle clean build`
5. Run tests with `java -jar my-automated-tests.jar`

Check out [TestNG + Gradle](sunshine-testng-integration-tests/build.gradle) or
[JUnit + Gradle](sunshine-junit4-integration-tests/build.gradle) integration examples.
Look [here](sunshine-junit4-integration-tests/build.gradle) if you wish to configure `fat jar` with TestNG + Gradle +
[Gradle's Shadow plugin](https://github.com/johnrengelman/shadow).

How to customize Sunshine?
==========================
Filter tests to be run
----------------------
[Java pattern matching](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html) is used to filter
Java classes. Sunshine uses a string representation of a class as an input to a filter. For instance,
you have `LoginTest` class in `com.example.mypackage` package. It will be converted to `com.example.mypackage.LoginTest`
and then put to the filter.

The default filter enables all classes that have `test` word in the class name
(a regex is **`(.+)([Tt]est)([\\w\\d]+)?`**). If you wish to redefine the default filter, just add `-Dtests=your-regex`
argument to your run command. For instance, `java -Dtests="^(com.company.smoke)(.+)" -jar my-automated-tests.jar`
allows Sunshine to use classes only from `com.company.smoke` package.

TestNG configuration
--------------------
@todo #18:2h Describe how to configure custom TestNG run.

Junit 4 configuration
---------------------
@todo #18:2h Describe how to configure custom Junit 4 run.

How to contribute?
==================
If you have any questions or something is not clear for you or want more functionality then please submit 
[new issue](https://github.com/tatools/sunshine/issues/new).

Before sending any pull request, please submit new issue or pick up existing one, discuss requirements and 
implementation details (optional).
