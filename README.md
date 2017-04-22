sunshine
========

"sunshine" is a Java library, with allows you to run your automated tests without build systems (like maven, gradle).

[![Build Status](https://travis-ci.org/tatools/sunshine.svg?branch=master)](https://travis-ci.org/tatools/sunshine)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![Issue Stats](http://issuestats.com/github/tatools/sunshine/badge/issue)](http://issuestats.com/github/tatools/sunshine)
[![Issue Stats](http://issuestats.com/github/tatools/sunshine/badge/pr)](http://issuestats.com/github/tatools/sunshine)

Join us
-------
Join **#sunshine** channel on our <a href='https://slackin-mrxyrwvjaf.now.sh/'><img src="https://slackin-mrxyrwvjaf.now.sh/badge.svg"></a>.

Development
-----------
Please use gradle wrapper to build this project:
```
./gradlew <task> (on Unix-like platforms such as Linux and Mac OS X)
gradlew <task> (on Windows using the gradlew.bat batch file)
```

Filter tests
------------
[Java Pattern matching](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html) is used to filter 
required Java classes. Sunshine uses a string representation of a class to filter files with tests. For instance, 
you have `LoginTest` class in `com.example.mypackage` package. It will be converted to `com.example.mypackage.LoginTest`
and then put to the filter. By default filter enables all classes that have `test` word in the class name 
(`(.+)([Tt]est)([\\w\\d]+)?` is the default regex). If you wish define your own tests filter, you can provide run 
command with own regex: `java -Dtests="your regex here" -jar my-tests.jar`.