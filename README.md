sunshine
========

[![Join the chat at https://gitter.im/tatools/sunshine](https://badges.gitter.im/tatools/sunshine.svg)](https://gitter.im/tatools/sunshine?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/tatools/sunshine.svg?branch=master)](https://travis-ci.org/tatools/sunshine)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![Rultor.com](http://www.rultor.com/b/tatools/sunshine)](http://www.rultor.com/p/tatools/sunshine)

What is Sunshine?
=================
**Sunshine** is a wrapper on Java xUnit test runners (such as TestNG, Junit...) which allows automatically
[find classes with tests](#filter-tests-to-be-run) within the jar file, passes them to desired test runner and reports
an execution status.

Tests runners
-------------

| Component       | Dependency   | Verified on | Tests runner class |
| --------------- | :----------: | ----------- | ------------------ |
| sunshine-testng | [![Maven Central](https://img.shields.io/maven-central/v/io.github.tatools/sunshine-testng.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.tatools/sunshine-testng) | [TestNG](http://testng.org) `6.11` | [`io.github.tatools.sunshine.testng.Sunshine`](sunshine-testng/src/main/java/io/github/tatools/sunshine/testng/Sunshine.java) |
| sunshine-junit4 | [![Maven Central](https://img.shields.io/maven-central/v/io.github.tatools/sunshine-junit4.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.tatools/sunshine-junit4) | [JUnit4](http://junit.org/junit4) `4.11` | [`io.github.tatools.sunshine.junit4.Sunshine`](sunshine-junit4/src/main/java/io/github/tatools/sunshine/junit4/Sunshine.java) |


How does Sunshine work?
=======================
Once you have configured Sunshine for your project, you are able to build `my-automated-tests.jar`
file with your automated tests.
Next time, when you will run automated tests with `java -jar my-automated-tests.jar`, Sunshine will:
1. scan all classes within your JAR
2. filter classes by [provided pattern](#filter-tests-to-be-run)
3. run found tests using defined test runner
4. report run statistic and exit code of the test runner

Sample output of [internal integration tests](sunshine-testng-integration-tests):
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

How to start using?
===================
1. Make sure you have the following project structure:
    ```
    src/main   <- your code here, including automated tests
    src/test   <- your unit tests here
    ```
2. Add Sunshine [dependency](#tests-runners) based on your tests runner
3. Configure [tests runner](#tests-runners) class for your JAR (like [here](sunshine-testng-integration-tests/build.gradle) at line 4)
4. Build JAR file with `mvn clean package` or `gradle clean build`
5. Run tests with `java -jar my-automated-tests.jar`

Check out [TestNG + Gradle](sunshine-testng-integration-tests/build.gradle) or
[JUnit + Gradle](sunshine-junit4-integration-tests/build.gradle) integration examples.
Look [here](sunshine-junit4-integration-tests/build.gradle) if you wish to configure `fat jar` with TestNG + Gradle +
[Gradle's Shadow plugin](https://github.com/johnrengelman/shadow). And 
[here](https://github.com/extsoft/jcat/commit/65558e95cb94a2c995ec67fa09bf501a740dcff4/pom.xml#diff-600376dffeb79835ede4a0b285078036)
is an example of a `fat jar` with Maven + TestNG.

How to customize Sunshine?
==========================
Filter tests to be run
----------------------
[Java pattern matching](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html) is used to filter
Java classes. Sunshine uses a string representation of a class as an input to a filter. For instance,
you have `LoginTest` class in `com.example.mypackage` package. It will be converted to `com.example.mypackage.LoginTest`
and then put to the filter.

The default filter enables all classes that have `Test` word in the class name
(a regex is **`(.+)(Test)([\w\d]+)?`**). If you wish to redefine the default filter, just add `-Dtests-regex=your-regex`
argument to your run command. For instance, `java -Dtests-regex="^(com.company.smoke)(.+)" -jar my-automated-tests.jar`
allows Sunshine to use classes only from `com.company.smoke` package.

Create custom tests runner
--------------------------
Although Sunshine has [predefined tests runners](#tests-runners), in some cases you may need a custom one. For instance, 
you would like to run the same tests with different configurations (managed by listeners etc.) or to define your own 
filtering rules.

That's why Sunshine design allows easy create a runner. To do that, first of all, take a look for 
[standard runners](#tests-runners) and, of course, custom one like in 
[extsoft/jcat](https://github.com/extsoft/jcat/commit/65558e95cb94a2c995ec67fa09bf501a740dcff4).

How to contribute?
==================
If you have any questions or something is not clear for you or want more functionality then please submit 
[new issue](https://github.com/tatools/sunshine/issues/new).

Before sending any pull request, please submit new issue or pick up existing one, discuss requirements and 
implementation details (optional).
