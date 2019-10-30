# Getting started
You need to follow several steps to integrate Sunshine with your automated tests.

## Step 1: Make proper project's structure
Suppose, there is a Maven project with automated tests
```
.
├── README.md
├── pom.xml
└── src
   ├── main
   └── test
```
Usually, the code is located under `src/main` directory and automated tests under `src/test`.
According to [Sunshine's concept](concept.md), the code and automated tests have to live together in `src/main`.

So, please move everything to `src/main` except unit tests.

## Step 2: Add Sunshine library
Based on the xUnit engine you are using, please select an appropriate library and add to your build configuration.
Available libraries:
- [![](https://img.shields.io/maven-central/v/org.tatools/sunshine-testng.svg?label=sunshine-testng)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-testng%22)
- [![](https://img.shields.io/maven-central/v/org.tatools/sunshine-junit4.svg?label=sunshine-junit4)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-junit4%22)
- [![](https://img.shields.io/maven-central/v/org.tatools/sunshine-junit5.svg?label=sunshine-junit5)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-junit5%22)

To find out more references, please visit [artifacts page](artifacts.md).

## Step 3: Configure code packaging
The recommended packaging is an `uber-JAR` - also known as a `fat JAR` or `JAR with dependencies` -
is a JAR file that contains not only a Java program but embeds its dependencies as well.

How to configure an uber-JAR depends on a build tool is used by a project. But regardless of a way
of the configuration, [a JAR's entry point](https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html)
has to be defined.

There are predefined classes to be used as the entry points for each test runner. However,
Sunshine was designed to encourage you to create your own configurations based on the project's requirements.
Please visit [entry points page](entry-points.md) to find out more.
