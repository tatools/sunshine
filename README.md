sunshine
========

[![Build Status](https://travis-ci.org/tatools/sunshine.svg?branch=master)](https://travis-ci.org/tatools/sunshine)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![Issue Stats](http://issuestats.com/github/tatools/sunshine/badge/issue)](http://issuestats.com/github/tatools/sunshine)
[![Issue Stats](http://issuestats.com/github/tatools/sunshine/badge/pr)](http://issuestats.com/github/tatools/sunshine)

[![Rultor.com](http://www.rultor.com/b/tatools/sunshine)](http://www.rultor.com/p/tatools/sunshine)

@todo #18:15m Add maven central badge here.

What is Sunshine?
=================
**Sunshine** is a Java library which allows you to distribute automated tests as an Java application (JAR file).

How does Sunshine work?
=======================
Once you have configured Sunshine for your project, you are able to build `my-tests.jar` file with your automated tests.
Next time, when you will run automated tests with `java -jar my-tests.jar`, Sunshine will 
1. scan all classes within your JAR
2. filter classes by provided pattern (find out classes with desired tests)
3. run found tests with configured test runners
4. print pass/fail statistic

Supported Java tests runners
============================
- [TestNG](http://testng.org) - tested on `6.11`
- [JUnit 4](http://junit.org/junit4) - tested on `4.11`

How to start using?
===================
1. Make sure you have the following project structure:
    ```
    src/main   <- your code here, including automated tests
    src/test   <- your unit tests here
    ```
2. Add Sunshine dependency based on your tests runner:
    - use `sunshine-testng` for TestNG
    - use `sunshine-junit4` for Junit 4
3. Configure main class for your JAR:
    - use `io.github.tatools.sunshine.testng.Sunshine` for TestNG
    - use `io.github.tatools.sunshine.junit4.Sunshine` for JUnit 4
    - or create your own configuration
4. Create JAR file with `mvn clean build` or `gradle clean build`
5. Run tests with `java -jar my-automated-tests.jar`

How to configure build system?
==============================
Gradle
------
Check out [TestNG + Gradle](sunshine-testng-integration-tests/build.gradle) or 
[JUnit + Gradle](sunshine-junit4-integration-tests/build.gradle) integration examples.

Maven
-----
@todo #18 Add an example of Sunshine and Maven integration.

How to configure Java tests runner
==================================
TestNG configuration
--------------------
@todo #18:2h Describe how to configure custom TestNG run.

Junit 4 configuration
---------------------
@todo #18:2h Describe how to configure custom Junit 4 run.

How do tests filtering work?
------------------------------
[Java Pattern matching](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html) is used to filter 
required Java classes. Sunshine uses a string representation of a class to filter files with tests. For instance, 
you have `LoginTest` class in `com.example.mypackage` package. It will be converted to `com.example.mypackage.LoginTest`
and then put to the filter. By default, filter enables all classes that have `test` word in the class name 
(`(.+)([Tt]est)([\\w\\d]+)?` is the default regex). If you wish to define your own tests filter, you can provide the run 
command with own regex: `java -Dtests="your regex here" -jar my-tests.jar`.

How to contribute?
==================
If you have any questions or something is not clear for you or want more functionality then please submit 
[new issue](https://github.com/tatools/sunshine/issues/new).

Before sending any pull request, please submit new issue or pick up existing one, discuss requirements and 
implementation details (optional).
