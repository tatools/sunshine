# Entry points

```java
// report results to CLI
new Sun(
    // use TestNg's tests
    new TestNGKernel(
        // seek for tests in current CLASSPATH
        new LoadableTestNGSuite(
            // package with tests to use (tests filter)
            new RegexCondition("^pro.extsoft.comments.tests(.+)?")
        )
    )
).shine();
```
