# Entry points
An entry point is a Java class which is configured for a JAR and will be used when 
```bash
java -jar my.jar
```
is executed.

## Design custom entry point
The `org.tatools.sunshine.core` package provides 3 main interfaces which are a base for any
Sunshine's wrapper:
- `Suite` defines a test suite and may be adapted to a test runner
- `Kernel` runs encapsulated `Suite` on desired test runner
- `Star` reports `Kernel`'s execution status to command line interface

Also, there is a `SunshineSuite` interface with several core implementations which allow seeking
and filtering of the classes to be treated as tests. Sunshine uses a string representation of a class
as an input to a filter which uses 
[Java pattern matching](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
to filter classes. For instance, there is a `LoginTest` class in `com.example.mypackage` package.
It will be converted to `com.example.mypackage.LoginTest` and then put to a filter.

Each wrapper provides its own implementations at least for `Suite` and `Kernel`. For instance,
if the classes located in `pro.extsoft.comments.tests` package have to be executed by TestNG and
status of the execution has to be reported to the CLI, the code snippet will look like
```java
new Sun(
    new TestNGKernel(
        new LoadableTestNGSuite(
            new RegexCondition("^pro.extsoft.comments.tests(.+)?")
        )
    )
).shine();
```
You can wrap it with any additional logic which is required for your tests execution. For instance,
some input arguments can be read to generate test data before testing, etc.

If you need an example, please take a look for [jcat repository](https://github.com/extsoft/jcat/blob/master/src/main/java/pro/extsoft/comments/App.java).

## Default TestNG entry point
Class: [`org.tatools.sunshine.testng.Sunshine`](https://github.com/tatools/sunshine/blob/master/sunshine-testng/src/main/java/org/tatools/sunshine/testng/Sunshine.java)

The class exposes the following behavior:
1. `java -jar my.jar` seeks for classes with word `Test` in the class name (a filter uses
`(.+)(Test)([\w\d]+)?` regex), runs discovered tests, and reports results to the CLI.
2. `java -Dtests-regex="^(com.company.smoke)(.+)" -jar my.jar` does the same as the previous one except
a class name has to match with `^(com.company.smoke)(.+)` regex.
3. `java -jar my.jar testng.xml` runs tests defined in `testng.xml` file (it can be either
[TestNG XML](http://testng.org/doc/documentation-main.html#testng-xml) or 
[TestNG YAML](http://testng.org/doc/documentation-main.html#yaml)).


## Default JUnit4 entry point
Class: [`org.tatools.sunshine.junit4.Sunshine`](https://github.com/tatools/sunshine/blob/master/sunshine-junit4/src/main/java/org/tatools/sunshine/junit4/Sunshine.java)

The class exposes the same behavior as default TestNG entry point exposes except the last option. All tests will be
executed using JUnit4.
