# Concept

Modern build tools such as [Maven](https://maven.apache.org) or [Gradle](https://gradle.org) have
a test phase of the build lifecycle to execute the unit tests of an application. This capability is
used in the automated testing to manage the execution of automated tests (instead of unit tests).
As the result, all automated tests are located under `src/test` as well as any test execution
configurations are managed through the build tools.

The used solution has 3 main gaps:
1. **There is no place for unit tests as it is already owned by automated tests.** But sometimes
unit tests are useful even for the automated testing as they allow to check some specific
implementations to be used during the automation.
2. **Hard to configure tests suites.** This is because you need to run all unit tests at the same
time during the project’s build cycle. And build tools support it very well. But for automated
tests, it is often required to run only a subset of tests (or even only single test). The build
tools are not so good at doing this.
3. **There is no chance to create a JAR file and distribute automated tests like a standard
Java archive.** That's why in addition to a Java installation, build tool and other dependencies are
required to run the tests. And this is a pain especially if you are supporting the tests execution
or trying to dockerize them.

**What does Sunshine offer?**

It wraps a test runner and allows programmatic configuration of the tests suites. This decouples
automated tests execution from a build tool and moves a project with automated tests toward
[the regular Java project structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).

Want to see a small demonstration? Please check out the video
<iframe width="560" height="315" src="https://www.youtube.com/embed/616eoKinbGk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

The code is located on [https://github.com/extsoft/jcat](https://github.com/extsoft/jcat). Feel free to check it out
and make your own experiments.

Now you are ready to move further with [Getting started](getting-started.md).
