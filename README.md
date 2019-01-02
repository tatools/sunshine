sunshine
========
Sunshine allows you to manage suits of your automated tests directly from Java code. It can work
on top of [TestNg](https://testng.org/doc/index.html) or [JUnit4](https://junit.org/junit4/).

Please read the users documentation on [http://sunshine.tatools.org](http://sunshine.tatools.org).


[![Join the chat at https://gitter.im/tatools/sunshine](https://badges.gitter.im/tatools/sunshine.svg)](https://gitter.im/tatools/sunshine?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/tatools/sunshine.svg?branch=master)](https://travis-ci.org/tatools/sunshine)
[![Documentation Status](https://readthedocs.org/projects/sunshine/badge/?version=latest)](http://sunshine.tatools.org/en/latest/?badge=latest)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![Rultor.com](http://www.rultor.com/b/tatools/sunshine)](http://www.rultor.com/p/tatools/sunshine)


Tests runners
-------------

| Component       | Dependency   | Verified on | Tests runner class |
| --------------- | :----------: | ----------- | ------------------ |
| sunshine-testng | [![Maven Central](https://img.shields.io/maven-central/v/org.tatools/sunshine-testng.svg)](https://maven-badges.herokuapp.com/maven-central/org.tatools/sunshine-testng) | [TestNG](http://testng.org) `6.11` | [`org.tatools.sunshine.testng.Sunshine`](sunshine-testng/src/main/java/org/tatools/sunshine/testng/Sunshine.java) |
| sunshine-junit4 | [![Maven Central](https://img.shields.io/maven-central/v/org.tatools/sunshine-junit4.svg)](https://maven-badges.herokuapp.com/maven-central/org.tatools/sunshine-junit4) | [JUnit4](http://junit.org/junit4) `4.11` | [`org.tatools.sunshine.junit4.Sunshine`](sunshine-junit4/src/main/java/org/tatools/sunshine/junit4/Sunshine.java) |

For `version` <= `0.3.0`

| Component       | Dependency   | Verified on | Tests runner class |
| --------------- | :----------: | ----------- | ------------------ |
| sunshine-testng | [![Maven Central](https://img.shields.io/maven-central/v/io.github.tatools/sunshine-testng.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.tatools/sunshine-testng) | [TestNG](http://testng.org) `6.11` | [`io.github.tatools.sunshine.testng.Sunshine`](sunshine-testng/src/main/java/io/github/tatools/sunshine/testng/Sunshine.java) |
| sunshine-junit4 | [![Maven Central](https://img.shields.io/maven-central/v/io.github.tatools/sunshine-junit4.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.tatools/sunshine-junit4) | [JUnit4](http://junit.org/junit4) `4.11` | [`io.github.tatools.sunshine.junit4.Sunshine`](sunshine-junit4/src/main/java/io/github/tatools/sunshine/junit4/Sunshine.java) |


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

Development notes
=================

Update docs
-----------
Before generate documentation, you need to install required Python's dependencies with `pip install -r docs/requirements.txt`.

When you are ready to review your changes, you can build static HTML pages with
```bash
cd docs
make html
open _build/html/index.html
```
